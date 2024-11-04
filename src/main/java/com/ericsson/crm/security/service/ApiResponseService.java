package com.ericsson.crm.security.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ericsson.crm.security.dto.ApiData;
import com.ericsson.crm.security.dto.ApiErrorResponse;
import com.ericsson.crm.security.dto.ApiResponse;
import com.ericsson.crm.security.enums.ResponseType;


@Service
public class ApiResponseService {

	public ApiResponse success(String dataName, Object data) {
		return new ApiResponse(ResponseType.SUCCESS.responseType, new ApiData(dataName, data));
	}

	public ApiResponse fail(String dataName, Object data) {
		return new ApiResponse(ResponseType.FAIL.responseType, new ApiData(dataName, data));
	}

	public ApiErrorResponse error(String message, Object data, HttpStatus code) {
		return new ApiErrorResponse(ResponseType.ERROR.responseType, message, data, code);
	}

}
