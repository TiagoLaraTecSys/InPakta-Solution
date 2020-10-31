package com.laratecsys.inpaktaService.Dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class DadosPessoaisDTO {
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min=5, max=120, message = "Tamanho máximo 120 e mínimo 5")
	private String dado;

	public DadosPessoaisDTO() {
		
	}
	
	
	public DadosPessoaisDTO(String dado) {
		super();
		this.dado = dado;
	}


	public String getDado() {
		return dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}
	
	

}
