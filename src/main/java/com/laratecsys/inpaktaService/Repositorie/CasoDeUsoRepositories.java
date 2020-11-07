package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;

@Repository
public interface CasoDeUsoRepositories extends JpaRepository<CasoDeUso, Integer> {
	
	@Transactional
	public List<CasoDeUso> findAllByClienteId(Integer id);
	
	Page<CasoDeUso> findAllByClienteId(Integer id, Pageable pageRequest);

	
} 
  