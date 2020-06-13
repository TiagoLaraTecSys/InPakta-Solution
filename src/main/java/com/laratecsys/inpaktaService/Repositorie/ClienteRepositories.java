package com.laratecsys.inpaktaService.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.laratecsys.inpaktaService.Domain.Cliente;

public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {
	
	
	@Transactional(readOnly = true)
	public Cliente findByEmail(String email);

}
