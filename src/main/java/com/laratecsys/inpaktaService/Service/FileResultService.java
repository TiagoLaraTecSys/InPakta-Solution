package com.laratecsys.inpaktaService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileResults;
import com.laratecsys.inpaktaService.Dto.FileResultsDTO;
import com.laratecsys.inpaktaService.Repositorie.FileResultsRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;

public class FileResultService {
	
	@Autowired
	private FileResultsRepositories fileResultsRepositories;
	
	public FileResults insert(FileResults fileResults) {
		
		UserSS userLogged = UserService.authenticated();
		
		if (userLogged == null) {
			throw new AuthorizationException("Não foi possível salvar os resultados");
		}
		
		return fileResultsRepositories.save(fileResults);
		
	}
	public List<FileResults> findingAllFileResultsByClienteId(){
		
		UserSS userLoged = UserService.authenticated();
		
		if(userLoged==null) {
			throw new AuthorizationException("Usuário não logado!");
		}
		
		List<FileResults> filePropertiesList = fileResultsRepositories.findByClienteId(new Cliente(userLoged.getId(), null, null, null,null));

		return filePropertiesList;
	}
	public FileResults fromDTO(FileResultsDTO obj) {
			
		FileResults newObj = new FileResults();
		
		newObj.setDicionario(obj.getDicionario());
		newObj.setDiretorio(obj.getDiretorio());
		newObj.setModelo(obj.getModelo());
		newObj.setModeloDoModulo(obj.getModeloDoModulo());
		newObj.setId_File(obj.getId_File());
		newObj.setNomeDoArquivo(obj.getNomeDoArquivo());
		newObj.setProbabilidade(obj.getProbabilidade());
	
		return newObj;
	}

}
