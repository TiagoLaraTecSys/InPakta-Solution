package com.laratecsys.inpaktaService.Domain.Redatasense.ERP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DadosPessoais {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String dado;
	
	@ManyToOne
	@JoinColumn(name="casodeuso_id")
	@JsonIgnore
	private CasoDeUso casoDeUso;
	
	public DadosPessoais() {
		
	}
	
	public DadosPessoais(Integer id,   String dado) {
		super();
		this.id = id;
		this.dado = dado;
	}
	
	public DadosPessoais(CasoDeUso casoDeUso) {
		super();
		this.casoDeUso = casoDeUso;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDado() {
		return dado;
	}
	public void setDado(String dado) {
		this.dado = dado;
	}

	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}	

}
