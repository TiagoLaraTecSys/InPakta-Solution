package com.laratecsys.inpaktaService.Domain.Redatasense.ERP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Enum.DataLifeCycle;

@Entity
public class CasoDeUso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy="id.casoDeUso")
	private Set<DadosCasoDeUso> itens = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.casoDeUso")
	private Set<CasosDeUsoSubject> casos = new HashSet<>();
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name= "datalifecycle")
	private Set<Integer> lifecycles = new HashSet<>();
	
	private Boolean useConsent;
	
	public CasoDeUso() {
		
	}
	
	public CasoDeUso(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
		
	public Set<DataLifeCycle> getLifecycles() {
		return lifecycles.stream().map(x -> DataLifeCycle.toEnum(x)).collect(Collectors.toSet());
	}

	public void addLifeCycle(DataLifeCycle lifecycle) {
		lifecycles.add(lifecycle.getCod());
	}

	public Boolean getUseConsent() {
		return useConsent;
	}

	public void setUseConsent(Boolean useConsent) {
		this.useConsent = useConsent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<DadosCasoDeUso> getItens() {
		return itens;
	}

	public void setItens(Set<DadosCasoDeUso> itens) {
		this.itens = itens;
	}
	
	

	public Set<CasosDeUsoSubject> getCasos() {
		return casos;
	}

	public void setCasos(Set<CasosDeUsoSubject> casos) {
		this.casos = casos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CasoDeUso(Integer id, String nome, String descricao, Cliente cliente,
			Set<Integer> lifecycles, Boolean useConsent) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cliente = cliente;
		this.lifecycles = lifecycles;
		this.useConsent = useConsent;
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
		CasoDeUso other = (CasoDeUso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
