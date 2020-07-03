package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;

public interface DbPropertiesRepositories extends JpaRepository<DbProperties, Integer> {
	
	@Query("SELECT t FROM DbProperties t where t.cliente IN :id and t.isActive=1")
	public List<DbProperties> findByClienteId(Cliente id);
}
