package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String label;
	private String message;
	
	public FieldMessage() {
	}

	public FieldMessage(String fieldName, String message) {
		this.label = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return label;
	}

	public void setFieldName(String fieldName) {
		this.label = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}