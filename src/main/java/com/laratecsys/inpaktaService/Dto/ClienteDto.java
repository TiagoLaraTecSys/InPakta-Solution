package com.laratecsys.inpaktaService.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClienteDto {
	
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min=5, max=120, message = "Tamanho máximo 120 e mínimo 5")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String sobNome;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Email
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String senha;
	
	public ClienteDto() {
		
	}
	
	public ClienteDto(String nome, String sobNome, String email) {
		super();
		
		this.nome = nome;
		this.sobNome = sobNome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobNome() {
		return sobNome;
	}
	public void setSobNome(String sobNome) {
		this.sobNome = sobNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
