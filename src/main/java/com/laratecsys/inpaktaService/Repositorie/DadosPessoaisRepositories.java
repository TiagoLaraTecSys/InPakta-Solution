package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosPessoais;

@Repository
public interface DadosPessoaisRepositories extends JpaRepository<DadosPessoais, Integer> {
	
	@Query("SELECT d FROM DadosPessoais d GROUP BY(dado)")
	List<DadosPessoais> findAllGroupByDado();
	
	DadosPessoais findByDado(String dado);
}
