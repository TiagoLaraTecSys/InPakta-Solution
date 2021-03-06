package com.laratecsys.inpaktaService.Domain.Redatasense.DTO;

import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;

public class DbPropertiesDTO {

	Integer id_db;
	String repository_name;
	String vendor;
	String driver;
	String username;
	String password;
	String dbschema;
	String url;
	Integer isActive;
	Integer cliente_id;
	Integer dataDiscoveryProperties_id;

	public DbPropertiesDTO() {

	}

	public DbPropertiesDTO(Integer id_db, String repository_name, String vendor, String driver, String username,
			String password, String dbschema, String url, Integer isActive, Integer cliente_id,
			Integer dataDiscoveryProperties_id) {
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
		this.cliente_id = cliente_id;
		this.dataDiscoveryProperties_id = dataDiscoveryProperties_id;
	}

	public DbPropertiesDTO(DbProperties dbProperties) {
		this.id_db = dbProperties.getId_db();
		this.repository_name = dbProperties.getRepository_name();
		this.vendor = dbProperties.getVendor();
		this.driver = dbProperties.getDriver();
		this.username = dbProperties.getUsername();
		this.password = dbProperties.getPassword();
		this.dbschema = dbProperties.getDbschema();
		this.url = dbProperties.getUrl();
		this.isActive = dbProperties.getIsActive();
		this.cliente_id = dbProperties.getCliente().getId();
	}

	public Integer getDataDiscoveryProperties_id() {
		return dataDiscoveryProperties_id;
	}

	public void setDataDiscoveryProperties_id(Integer dataDiscoveryProperties_id) {
		this.dataDiscoveryProperties_id = dataDiscoveryProperties_id;
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

	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

}
