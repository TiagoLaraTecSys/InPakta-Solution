package com.laratecsys.inpaktaService.Domain.Redatasense.ERP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DadosPessoais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String dado;
	
	@JsonIgnore
	@OneToMany(mappedBy="id.dadosPessoais")
	private Set<DadosCasoDeUso> itens = new HashSet<>();
	
	public DadosPessoais() {
		
	}
	
	public DadosPessoais(Integer id,   String dado) {
		super();
		this.id = id;
		this.dado = dado;
	}
	

	@JsonIgnore
	public List<CasoDeUso> getCasoDeUso(){
		List<CasoDeUso> lista = new ArrayList<>();
		
		for (DadosCasoDeUso x : itens) {
			lista.add(x.getCasoDeUso());
		}
		return lista;
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

	public Set<DadosCasoDeUso> getItens() {
		return itens;
	}

	public void setItens(Set<DadosCasoDeUso> itens) {
		this.itens = itens;
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
		DadosPessoais other = (DadosPessoais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	

	
}
