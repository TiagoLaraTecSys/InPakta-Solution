package com.laratecsys.inpaktaService.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;

public interface CasoDeUsoRepositories extends JpaRepository<CasoDeUso, Integer> {
	

}
