package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileResults;

public interface FileResultsRepositories extends JpaRepository<FileResults, Integer> {
	
	@Query("SELECT fr FROM FileResults fr"
			+ " JOIN fr.fileProperties fp"
			+ " JOIN fp.cliente c "
			+ " where fp.cliente IN :id")
	public List<FileResults>findByClienteId(Cliente id);
}
