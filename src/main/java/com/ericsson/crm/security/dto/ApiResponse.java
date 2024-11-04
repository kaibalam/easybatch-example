package com.ericsson.crm.security.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
	private String status;
	@JsonSerialize(using = CustomSerializer.class)
	private ApiData data;
}
