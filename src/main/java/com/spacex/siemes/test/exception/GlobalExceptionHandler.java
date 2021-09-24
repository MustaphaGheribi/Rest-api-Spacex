package com.spacex.siemes.test.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity handleNotFoundException(NotFoundException ex) {
		return new ResponseEntity<>(body(ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	private Map<String, String> body(String message) {
		Map<String, String> map = new HashMap<>();
		map.put("message", message);
		return map;
	}
}
