package com.laratecsys.inpaktaService.Dto;

public class SubjectDTO {

	
	private String email;
	private String codigoValidacao;
	private Boolean validado;
	private Boolean feito;
	
	private Integer tipo;
	
	private String subDominio;

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
	
	
	
	
}
