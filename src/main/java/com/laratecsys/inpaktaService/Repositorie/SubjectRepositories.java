package com.laratecsys.inpaktaService.Repositorie;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;

public interface SubjectRepositories extends JpaRepository<Subject, Integer> {
	
	@Transactional(readOnly = true)
	public Subject findByCodigoValidacao(String validatecode);
	
	Page<Subject> findAllByClienteId(Integer id, Pageable pageRequest);
} 
