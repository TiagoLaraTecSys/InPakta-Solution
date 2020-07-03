package com.laratecsys.inpaktaService.Domain.Redatasense;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laratecsys.inpaktaService.Domain.Cliente;

@Entity
public class DbProperties {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id_db;
	String	repository_name;
	String	vendor;
	String	driver;
	String	username;
	String	password;
	String	dbschema;
	String	url;
	Integer	isActive;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dbProperties",cascade = CascadeType.ALL)
	private List<DataResult> resultados = new ArrayList<>();
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	public DbProperties() {
		
	}

	public DbProperties(Integer id_db, String repository_name, String vendor, String driver, String username,
			String password, String dbschema, String url, Integer isActive,	Cliente cliente) {
		super();
		this.id_db = id_db;
		this.repository_name = repository_name;
		this.vendor = vendor;
		this.driver = driver;
		this.username = username;
		this.password = password;
		this.dbschema = dbschema;
		this.url = url;
		this.isActive = isActive;
		this.cliente = cliente;
	}

	public DbProperties(Integer id_db, String repository_name, String vendor, String driver, String username,
			String password, String dbschema, String url, Integer isActive) {
		super();
		this.id_db = id_db;
		this.repository_name = repository_name;
		this.vendor = vendor;
		this.driver = driver;
		this.username = username;
		this.password = password;
		this.dbschema = dbschema;
		this.url = url;
		this.isActive = isActive;
	}

	public Integer getId_db() {
		return id_db;
	}

	public void setId_db(Integer id_db) {
		this.id_db = id_db;
	}

	public String getRepository_name() {
		return repository_name;
	}

	public void setRepository_name(String repository_name) {
		this.repository_name = repository_name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbschema() {
		return dbschema;
	}

	public void setDbschema(String dbschema) {
		this.dbschema = dbschema;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	public List<DataResult> getResultados() {
		return resultados;
	}

	public void setResultados(List<DataResult> resultados) {
		this.resultados = resultados;
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
		result = prime * result + ((id_db == null) ? 0 : id_db.hashCode());
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
		DbProperties other = (DbProperties) obj;
		if (id_db == null) {
			if (other.id_db != null)
				return false;
		} else if (!id_db.equals(other.id_db))
			return false;
		return true;
	}
	
	
}
