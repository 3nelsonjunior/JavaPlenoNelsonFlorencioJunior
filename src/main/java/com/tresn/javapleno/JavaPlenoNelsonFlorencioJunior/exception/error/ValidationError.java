package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.error;

import java.util.ArrayList;
import java.util.List;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.FieldMessage;


public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp, String path) {
		super(status, msg, timeStamp, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}
}
