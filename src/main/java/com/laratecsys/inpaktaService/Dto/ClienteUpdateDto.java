package com.laratecsys.inpaktaService.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClienteUpdateDto {
	
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min=5, max=120, message = "Tamanho máximo 120 e mínimo 5")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String sobNome;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Email
	private String email;
	
	private String organizacao;
	
	private Boolean automated;
	
	private String subDominio;
	private String cor;
	private String icone;
	
	
	public String getSubDominio() {
		return subDominio;
	}

	public void setSubDominio(String subDominio) {
		this.subDominio = subDominio;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
	}

	public Boolean getAutomated() {
		return automated;
	}

	public void setAutomated(Boolean automated) {
		this.automated = automated;
	}

	public ClienteUpdateDto() {
		
	}
	
	public ClienteUpdateDto(String nome, String sobNome, 
			String email, String organizacao, Boolean automated,String subDominio,String cor, String icone) {
		super();
		
		this.nome = nome;
		this.sobNome = sobNome;
		this.email = email;
		this.organizacao = organizacao;
		this.automated = automated;
		this.subDominio = subDominio;
		this.cor = cor;
		this.icone = icone;
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


}
