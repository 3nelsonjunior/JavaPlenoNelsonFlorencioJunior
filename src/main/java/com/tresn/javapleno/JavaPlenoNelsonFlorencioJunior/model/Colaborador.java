package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.validation.interfaceValidation.ColaboradorPost;

@Document(collection = "Colaboradores")
@ColaboradorPost
public class Colaborador implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	@DBRef
	private Setor setor;
	
	public Colaborador() {
		
	}
	
	
	public Colaborador(String id, String nome, String cpf, String telefone, String email, Setor setor) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.setor = setor;
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
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	

}
