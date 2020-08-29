package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DataResult;

public interface DataResultRepositories extends JpaRepository<DataResult, Integer> {
	
	public List<DataResult>findByClienteId(Cliente id);

}
