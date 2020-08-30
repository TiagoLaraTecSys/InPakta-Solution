package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;

public interface FilePropertiesRepositories extends JpaRepository<FileProperties, Integer> {
	
	@Query("SELECT t FROM FileProperties t where t.cliente IN :id")
	public List<FileProperties> findByClienteId(Cliente id);
}
