package com.laratecsys.inpaktaService.Dto;

public class SubjectValidateDTO {
	
	private String codigoValidacao;
	private Boolean validado;
	
	public SubjectValidateDTO() {}
	
	public SubjectValidateDTO(String codigoValidacao, Boolean validado) {
		super();
		this.codigoValidacao = codigoValidacao;
		this.validado = validado;
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
	
	

}
