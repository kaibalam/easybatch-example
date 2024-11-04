package com.ericsson.crm.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AuthorizationResponse {
	
	@JsonProperty("cod_error")
	private long codError;
	@JsonProperty("registros")
	private long registros;
	@JsonProperty("estado")
	private String estado;
	@JsonProperty("descripcionError")
	private String descripcionError;
	@JsonProperty("fecha")
	private String fecha;
	@JsonProperty("retorno")
	private SecUsuario usuario;
}
