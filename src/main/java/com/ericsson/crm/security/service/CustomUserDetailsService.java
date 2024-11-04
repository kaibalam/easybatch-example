package com.ericsson.crm.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ericsson.crm.security.dto.AuthorizationRequest;
import com.ericsson.crm.security.dto.SecUsuario;
import com.ericsson.crm.security.handler.AppException;
import com.ericsson.crm.security.util.Constants;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private SecurityService securityService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			SecUsuario secUsuario = securityService.getDatabaseUser(username);
			return new User(secUsuario.getUsuario(), "{empty}", new ArrayList<>());
		} catch (AppException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

	public UserDetails loadUserByAviToken(String aviToken) throws AppException {
		SecUsuario secUsuario = securityService
				.authenticateUser(new AuthorizationRequest(aviToken, Constants.AVI_APP_NAME));
		return new User(secUsuario.getUsuario(), "{empty}", new ArrayList<>());
	}

}
