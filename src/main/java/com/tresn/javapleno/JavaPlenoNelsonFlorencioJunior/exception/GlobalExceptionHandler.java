package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.error.StandardError;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.error.ValidationError;
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
	
	// Erros de validação
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> erroValidacao(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidationError err = new ValidationError(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de Validação!!!",
				System.currentTimeMillis(), request.getRequestURI());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}

}