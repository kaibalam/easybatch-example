package com.ericsson.crm.security.enums;

public enum ResponseMessages {

	INVALID_REQUEST("invalid request"), UNAUTHORIZED_USER("user is not authenticated or expired token"),
	CONFIGURATION_NOT_FOUND("configuration not found"), INTERNAL_SERVER_ERROR("internal server error");

	public final String message;

	private ResponseMessages(String message) {
		this.message = message;
	}

}
