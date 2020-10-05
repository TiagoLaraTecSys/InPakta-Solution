package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;

public interface SubjectRepositories extends JpaRepository<Subject, Integer> {
	
} 
