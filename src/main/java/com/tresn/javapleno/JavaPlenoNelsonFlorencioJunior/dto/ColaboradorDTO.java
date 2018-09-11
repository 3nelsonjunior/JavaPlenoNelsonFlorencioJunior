package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.dto;

import java.io.Serializable;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Colaborador;

public class ColaboradorDTO implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String email;
	
	public ColaboradorDTO() {
		
	}
	
	public ColaboradorDTO(Colaborador colaborador) {
		this.id = colaborador.getId();
		this.nome = colaborador.getNome();
		this.email = colaborador.getEmail();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
