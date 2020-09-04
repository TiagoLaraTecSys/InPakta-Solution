package com.laratecsys.inpaktaService.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.laratecsys.inpaktaService.Domain.Redatasense.FileResults;
import com.laratecsys.inpaktaService.Repositorie.FileResultsRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;

public class FileResultService {
	
	@Autowired
	private FileResultsRepositories fileResultsRepositories;
	
	public void insert(FileResults fileResults) {
		
		UserSS userLogged = UserService.authenticated();
		
		if (userLogged == null) {
			throw new AuthorizationException("Não foi possível salvar os resultados");
		}
		
		fileResultsRepositories.save(fileResults);
		
	}

}
