package com.docemonos.springcruddemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.docemonos.springcruddemo.dto.ErrorDTO;

@ControllerAdvice(basePackages = {"com.docemonos.springcruddemo.controller"})
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDTO> capturaExcepcion(Exception e) {
		return new ResponseEntity<>(new ErrorDTO(404, e.getMessage()), HttpStatus.NOT_FOUND);
	}
}
