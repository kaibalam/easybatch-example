package com.ericsson.crm.security.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiErrorResponse {
	private String status;
	private String message;
	private Object data;
	private HttpStatus code;
	
}
