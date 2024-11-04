package com.ericsson.crm.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.crm.security.dto.ApiResponse;
import com.ericsson.crm.security.dto.AuthorizationRequest;
import com.ericsson.crm.security.service.ApiResponseService;
import com.ericsson.crm.security.service.SecurityService;

@RestController
public class SecurityController {

	@Autowired
	private SecurityService securityService;
	@Autowired
	private ApiResponseService apiResponseService;

	@PostMapping("/security/authorization")
	public ResponseEntity<ApiResponse> authenticateUser(@RequestBody AuthorizationRequest request) throws Exception {
		return ResponseEntity.ok(apiResponseService.success("user", securityService.authenticateUser(request)));
	}
}
