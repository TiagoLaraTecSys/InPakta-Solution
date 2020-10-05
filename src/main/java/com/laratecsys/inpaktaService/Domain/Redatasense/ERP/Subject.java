package com.laratecsys.inpaktaService.Domain.Redatasense.ERP;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Enum.DataLifeCycle;
import com.laratecsys.inpaktaService.Enum.TipoSubject;

@Entity
public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date data;
	private String email;
	private String codigoValidacao;
	private Boolean validado;
	private Boolean feito;
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name= "tiposolicitacao")
	private Set<Integer> solicitacao = new HashSet<>();
	
	public Subject() {
		
	}
	
	public void addSolicitacao(TipoSubject solicit) {
		solicitacao.add(solicit.getCod());
	}

	public Set<TipoSubject> getSolicitacao() {
		return solicitacao.stream().map(x -> TipoSubject.toEnum(x)).collect(Collectors.toSet());
	}

	
	public Subject(Integer id, Date data, String email, String codigoValidacao, Boolean validado) {
		super();
		this.id = id;
		this.data = data;
		this.email = email;
		this.codigoValidacao = codigoValidacao;
		this.validado = validado;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

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

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Subject other = (Subject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
