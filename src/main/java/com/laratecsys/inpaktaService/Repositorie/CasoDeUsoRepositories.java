package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;

public interface CasoDeUsoRepositories extends JpaRepository<CasoDeUso, Integer> {
	
	@Transactional
	public List<CasoDeUso> findAllByClienteId(Integer id);
	
} 
