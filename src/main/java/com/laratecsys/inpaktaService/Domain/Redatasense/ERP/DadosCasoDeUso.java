package com.laratecsys.inpaktaService.Domain.Redatasense.ERP;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DadosCasoDeUso implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private DadosCasoDeUsoPK id = new DadosCasoDeUsoPK();
	
	public DadosCasoDeUso() {
		
	}

	public DadosCasoDeUso(CasoDeUso casoDeUso, DadosPessoais dadosPessoais) {
		super();
		this.id.setCasoDeUso(casoDeUso);
		this.id.setDadosPessoais(dadosPessoais);
	}
	
	public void setCasoDeUso(CasoDeUso casoDeUso) {
		id.setCasoDeUso(casoDeUso);
	}
	
	@JsonIgnore
	public CasoDeUso getCasoDeUso() {
		return id.getCasoDeUso();
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		id.setDadosPessoais(dadosPessoais);
	}
	
	
	public DadosPessoais getDadosPessoais() {
		return id.getDadosPessoais();
	}

	public DadosCasoDeUsoPK getId() {
		return id;
	}

	public void setId(DadosCasoDeUsoPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DadosCasoDeUso other = (DadosCasoDeUso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
