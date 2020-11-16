package com.laratecsys.inpaktaService.Dto;

public class SubjectDTO {

	
	private String email;
	private String codigoValidacao;
	private Boolean validado;
	private Boolean feito;
	
	private Integer tipo;
	
	private String subDominio;

	private String nome;
	private String sobNome;
	private String cpf;
	private String consideracoes;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoValidacao() {
		return codigoValidacao;
	}

	public void setCodigoValidacao(String codigoValidacao) {
		this.codigoValidacao = codigoValidacao;
	}

	public Boolean getValidado() {
		return validado;
	}

	public void setValidado(Boolean validado) {
		this.validado = validado;
	}

	public Boolean getFeito() {
		return feito;
	}

	public void setFeito(Boolean feito) {
		this.feito = feito;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getSubDominio() {
		return subDominio;
	}

	public void setSubDominio(String subDominio) {
		this.subDominio = subDominio;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getConsideracoes() {
		return consideracoes;
	}

	public void setConsideracoes(String consideracoes) {
		this.consideracoes = consideracoes;
	}
	
	
	
	
}
