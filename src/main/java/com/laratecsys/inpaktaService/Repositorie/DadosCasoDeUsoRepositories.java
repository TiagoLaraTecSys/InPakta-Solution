package com.laratecsys.inpaktaService.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosCasoDeUso;

@Repository
public interface DadosCasoDeUsoRepositories extends JpaRepository<DadosCasoDeUso, Integer> {

}
