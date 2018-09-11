package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.error.StandardError;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.type.ObjectNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {


	// objeto não encontrado
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}