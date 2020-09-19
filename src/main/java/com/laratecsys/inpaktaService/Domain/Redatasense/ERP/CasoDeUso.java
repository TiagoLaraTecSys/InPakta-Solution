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
import javax.persistence.OneToMany;

import com.laratecsys.inpaktaService.Enum.DataLifeCycle;

@Entity
public class CasoDeUso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy="casoDeUso", cascade= CascadeType.ALL)
	private List<DadosPessoais> dadosPessoais = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name= "datalifecycle")
	private Set<Integer> lifecycles = new HashSet<>();
	
	private Boolean useConsent;
	
	public CasoDeUso() {
		
	}
	
	public CasoDeUso(Integer id, String nome, String descricao, List<DadosPessoais> dadosPessoais) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dadosPessoais = dadosPessoais;
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

	public List<DadosPessoais> getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(List<DadosPessoais> dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}
	
}
