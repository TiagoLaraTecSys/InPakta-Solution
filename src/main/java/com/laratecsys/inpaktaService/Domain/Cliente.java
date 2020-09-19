package com.laratecsys.inpaktaService.Domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;
import com.laratecsys.inpaktaService.Enum.Perfil;
import com.laratecsys.inpaktaService.Enum.TipoCliente;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String sobNome;
	private String email;
	private String CpfOuCnpj;
	private Integer tipoCliente;
	
	@JsonIgnore
	private String senha;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<DbProperties> dbProperties = new ArrayList<>();
	
	@OneToMany(mappedBy= "cliente", cascade = CascadeType.ALL)
	private List<FileProperties> fileProperties = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<CasoDeUso> casoDeUso = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "perfis")
	private Set<Integer> perfis = new HashSet<>();
	
	public Cliente() {
		
	}
	

	public List<CasoDeUso> getCasoDeUso() {
		return casoDeUso;
	}



	public void setCasoDeUso(List<CasoDeUso> casoDeUso) {
		this.casoDeUso = casoDeUso;
	}



	public Cliente(Integer id, String nome, String sobNome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobNome = sobNome;
		this.email = email;
		this.senha = senha;
		
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
	public String getSobNome() {
		return sobNome;
	}
	public void setSobNome(String sobNome) {
		this.sobNome = sobNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public List<DbProperties> getDbProperties() {
		return dbProperties;
	}

	public void setDbProperties(List<DbProperties> dbProperties) {
		this.dbProperties = dbProperties;
	}

	
	public String getCpfOuCnpj() {
		return CpfOuCnpj;
	}


	public void setCpfOuCnpj(String cpfOuCnpj) {
		CpfOuCnpj = cpfOuCnpj;
	}

	

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}


	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis() {
		
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	

	public List<FileProperties> getFileProperties() {
		return fileProperties;
	}


	public void setFileProperties(List<FileProperties> fileProperties) {
		this.fileProperties = fileProperties;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
