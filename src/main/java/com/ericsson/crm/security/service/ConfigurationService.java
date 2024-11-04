package com.ericsson.crm.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ericsson.crm.security.entity.AppConfiguration;
import com.ericsson.crm.security.enums.ResponseMessages;
import com.ericsson.crm.security.handler.AppException;
import com.ericsson.crm.security.repository.ConfigurationRepository;

@Service
public class ConfigurationService {

	@Autowired
	private ConfigurationRepository configurationRepository;
	@Autowired
	private ApiResponseService apiResponseService;

	public AppConfiguration getConfigurationAviUrl() throws AppException {
		return configurationRepository
				.findByAplicacionAndTipoObjetoAndActivadaAndObjeto("AVI", "SeguridadWS", "S", "URL")
				.orElseThrow(() -> new AppException(
						apiResponseService.error(ResponseMessages.CONFIGURATION_NOT_FOUND.message,
								"avi web service URL", HttpStatus.NOT_FOUND)));
	}

}
