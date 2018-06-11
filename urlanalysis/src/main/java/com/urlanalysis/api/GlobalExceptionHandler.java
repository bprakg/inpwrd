package com.urlanalysis.api;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public ResponseEntity<java.lang.Object> handleExceptionInternal(ConstraintViolationException ex,
			java.lang.Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info(ex.getMessage());
		return handleExceptionInternal(ex, ex.getMessage(), headers, status, request);
	}

}
