package com.laratecsys.inpaktaService.Domain.Redatasense.ERP;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CasosDeUsoSubject implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private CasosDeUsoSubjectPK id = new CasosDeUsoSubjectPK();
	
	private Boolean consentimento;
	
	public CasosDeUsoSubject() {
		
	}

	public CasosDeUsoSubject(CasoDeUso casoDeUso, Subject subject, Boolean consentimento) {
		super();
		this.id.setCasoDeUso(casoDeUso);
		this.id.setSubject(subject);
		this.consentimento = consentimento;
	}
	
	public void setCasoDeUso(CasoDeUso casoDeUso) {
		id.setCasoDeUso(casoDeUso);
	}
	
	public CasoDeUso getCasoDeUso() {
		return id.getCasoDeUso();
	}

	
	public void setSubject(Subject subject) {
		id.setSubject(subject);
	}
	
	public Subject getSubject() {
		return id.getSubject();
	}
	
	public CasosDeUsoSubjectPK getId() {
		return id;
	}

	public void setId(CasosDeUsoSubjectPK id) {
		this.id = id;
	}
	
	

	public Boolean getConsentimento() {
		return consentimento;
	}

	public void setConsentimento(Boolean consentimento) {
		this.consentimento = consentimento;
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
		CasosDeUsoSubject other = (CasosDeUsoSubject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
