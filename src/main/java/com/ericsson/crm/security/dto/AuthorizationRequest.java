package com.ericsson.crm.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorizationRequest {

	private String parametro;
	private String pais;

}
