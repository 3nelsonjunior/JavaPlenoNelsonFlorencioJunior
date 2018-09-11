package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.type;

//Exceção personalizada(utilizada qdot findOne o objeto é null)
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// construtor recebe mensagem de exceção e passa pai(na camada resource)
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	// construtor recebe mensagem de exceção e passa pai(na camada resource)
	public ObjectNotFoundException(String msg, String path) {
		super(msg);
	}

	// construtor recebe mensagem de exceção com a "causa(algo aconteceu antes)" e
	// passa pai(na camada resource)
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
