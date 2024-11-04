package com.ericsson.crm.security.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.consystec.db.StatementException;
import com.consystec.ms.seguridad.dao.UsuarioDAO;
import com.consystec.ms.seguridad.excepciones.ExcepcionUsuarioNoExistente;
import com.consystec.ms.seguridad.orm.Usuario;
import com.ericsson.crm.security.JwtTokenProvider;
import com.ericsson.crm.security.UserPrincipal;
import com.ericsson.crm.security.dto.AuthorizationRequest;
import com.ericsson.crm.security.dto.AuthorizationResponse;
import com.ericsson.crm.security.dto.SecUsuario;
import com.ericsson.crm.security.entity.AppConfiguration;
import com.ericsson.crm.security.enums.ResponseMessages;
import com.ericsson.crm.security.handler.AppException;
import com.ericsson.crm.security.util.Constants;

@Service
public class SecurityService {

	private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);

	@Autowired
	private ConfigurationService configurationService;
	@Autowired
	private ApiResponseService apiResponseService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	@Qualifier("sec")
	private DataSource securityDataSource;

	public SecUsuario authenticateUser(AuthorizationRequest request) throws AppException {
		SecUsuario user = getUser(request.getParametro());
		UserPrincipal principal = UserPrincipal.create(user.getUsuario(), request.getParametro());
		Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, null);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		user.setToken(jwtTokenProvider.generateToken(authentication));
		return user;

	}

	public SecUsuario getUser(String aviToken) throws AppException {

		AppConfiguration url = configurationService.getConfigurationAviUrl();
		logger.debug(url.getValorObjeto1());
		String authorizationUrl = url.getValorObjeto1() + "/validarautorizacion/" + aviToken + "/" + Constants.AVI_APP_NAME;
		logger.debug(authorizationUrl);
		ResponseEntity<AuthorizationResponse> response = restTemplate.getForEntity(authorizationUrl,
				AuthorizationResponse.class);
		logger.debug("response: {}", response.getBody());
		return handleAuthorizationResponse(response.getBody());

	}

	private SecUsuario handleAuthorizationResponse(AuthorizationResponse response) throws AppException {
		if (ObjectUtils.isEmpty(response) || !"OK".equals(response.getEstado())) {
			throw new AppException(apiResponseService.error(ResponseMessages.UNAUTHORIZED_USER.message,
					response.getDescripcionError(), HttpStatus.UNAUTHORIZED));
		}
		return response.getUsuario();
	}

	public SecUsuario getDatabaseUser(String username) throws AppException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try (Connection conn = securityDataSource.getConnection()) {
			Usuario user = usuarioDAO.obtenerUsuario(conn, username);
			return new SecUsuario(user.getCreado_el(), user.getCreado_por(), user.getSecusuarioid().longValue(),
					user.getUsuario(), user.getNombre(), user.getApellido(), user.getEmail(),
					user.getExpira().intValue(), user.getBloqueado().intValue(), user.getIntentos_fallidos().intValue(),
					user.getEstado(), user.getUsuario_ldap().intValue());
		} catch (ExcepcionUsuarioNoExistente e) {
			throw new AppException(apiResponseService.error(ResponseMessages.UNAUTHORIZED_USER.message, e.getMessage(),
					HttpStatus.UNAUTHORIZED));
		} catch (SQLException | StatementException e) {
			throw new AppException(apiResponseService.error(ResponseMessages.INTERNAL_SERVER_ERROR.message,
					e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}
