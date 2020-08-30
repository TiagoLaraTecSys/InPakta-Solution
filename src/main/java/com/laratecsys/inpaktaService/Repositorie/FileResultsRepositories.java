package com.laratecsys.inpaktaService.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileResults;

public interface FileResultsRepositories extends JpaRepository<FileResults, Integer> {
	
}
