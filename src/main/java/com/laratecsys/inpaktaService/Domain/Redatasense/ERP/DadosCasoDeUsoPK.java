package com.laratecsys.inpaktaService.Domain.Redatasense.ERP;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DadosCasoDeUsoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="casodeuso_id")
	private CasoDeUso casoDeUso;
	
	@ManyToOne
	@JoinColumn(name="dadospessoais_id")
	private DadosPessoais dadosPessoais;

	
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casoDeUso == null) ? 0 : casoDeUso.hashCode());
		result = prime * result + ((dadosPessoais == null) ? 0 : dadosPessoais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosCasoDeUsoPK other = (DadosCasoDeUsoPK) obj;
		if (casoDeUso == null) {
			if (other.casoDeUso != null)
				return false;
		} else if (!casoDeUso.equals(other.casoDeUso))
			return false;
		if (dadosPessoais == null) {
			if (other.dadosPessoais != null)
				return false;
		} else if (!dadosPessoais.equals(other.dadosPessoais))
			return false;
		return true;
	}
	
	
}
