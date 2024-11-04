package com.ericsson.crm.security.handler;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;
	private final Object error;

	public AppException(Object error) {
		this.error = error;
	}

	public Object getError() {
		return error;
	}

}
