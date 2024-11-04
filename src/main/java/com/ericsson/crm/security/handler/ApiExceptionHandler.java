package com.ericsson.crm.security.handler;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ericsson.crm.security.dto.ApiErrorResponse;
import com.ericsson.crm.security.enums.ResponseMessages;
import com.ericsson.crm.security.service.ApiResponseService;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

	@Autowired
	private ApiResponseService apiResponseService;

	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ApiErrorResponse> handleDataAccessException(DataAccessException e) {
		logger.error("", e);
		return new ResponseEntity<>(apiResponseService.error(ResponseMessages.INTERNAL_SERVER_ERROR.message, null,
				HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<>(
				apiResponseService.error(ResponseMessages.INVALID_REQUEST.message, errors, HttpStatus.BAD_REQUEST),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAppException(Exception e) {
		logger.error("", e);
		return setHttpStatusCode(e);
	}

	private ResponseEntity<Object> setHttpStatusCode(Exception e) {
		if (e instanceof AppException) {
			AppException ex = (AppException) e;
			if (ex.getError() instanceof ApiErrorResponse) {
				ApiErrorResponse error = (ApiErrorResponse) ex.getError();
				return new ResponseEntity<>(error, error.getCode());
			}
		}
		return new ResponseEntity<>(apiResponseService.error(e.getMessage(), null, HttpStatus.BAD_REQUEST),
				HttpStatus.BAD_REQUEST);
	}

}
