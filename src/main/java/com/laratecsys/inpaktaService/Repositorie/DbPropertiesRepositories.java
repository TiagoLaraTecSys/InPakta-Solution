package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;

public interface DbPropertiesRepositories extends JpaRepository<DbProperties, Integer> {
	
	public List<DbProperties> findByClienteId(Integer id);
}
