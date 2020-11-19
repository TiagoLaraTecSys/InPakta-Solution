package com.laratecsys.inpaktaService.Domain.Redatasense.ERP;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CasosDeUsoSubjectPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="casodeuso_id")
	private CasoDeUso casoDeUso;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;

	
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casoDeUso == null) ? 0 : casoDeUso.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		CasosDeUsoSubjectPK other = (CasosDeUsoSubjectPK) obj;
		if (casoDeUso == null) {
			if (other.casoDeUso != null)
				return false;
		} else if (!casoDeUso.equals(other.casoDeUso))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	
	
}
