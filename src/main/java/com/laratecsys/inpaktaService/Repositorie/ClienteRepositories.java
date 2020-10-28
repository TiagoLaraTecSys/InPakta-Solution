package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;

@Repository
public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {
	
	
	@Transactional(readOnly = true)
	public Cliente findByEmail(String email);
	
	@Transactional(readOnly = true)
	public Cliente findBySubDominio(String subDominio);

	@Transactional(readOnly = true)
	public List<Subject> findAllBySubDominio(String subDominio);
}
