package com.laratecsys.inpaktaService.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasosDeUsoSubject;

@Repository
public interface CasoDeUsoSubjectRepositories extends JpaRepository<CasosDeUsoSubject, Integer> {

}
