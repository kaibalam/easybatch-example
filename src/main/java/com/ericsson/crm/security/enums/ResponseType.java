package com.ericsson.crm.security.enums;

public enum ResponseType {
	
	SUCCESS("success"), FAIL("fail"), ERROR("error");
	
	public final String responseType;
	
	private ResponseType(String responseType) {
		this.responseType = responseType;
	}
	
}
