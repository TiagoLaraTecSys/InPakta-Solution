package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DataResult;

public interface DataResultRepositories extends JpaRepository<DataResult, Integer> {
	
	@Query("SELECT dr FROM DataResult dr"
			+ " JOIN dr.dbProperties dbp"
			+ " JOIN dbp.cliente c "
			+ " where dbp.cliente IN :id and dbp.isActive=1")
	public List<DataResult>findByClienteId(Cliente id);
	
}
