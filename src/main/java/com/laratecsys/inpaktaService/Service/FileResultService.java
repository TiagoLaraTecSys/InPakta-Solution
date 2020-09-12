package com.laratecsys.inpaktaService.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileResults;
import com.laratecsys.inpaktaService.Dto.FileResultsDTO;
import com.laratecsys.inpaktaService.Repositorie.FileResultsRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;

@Service
public class FileResultService {
	
	@Autowired
	private FileResultsRepositories fileResultsRepositories;
	
	public FileResults insert(FileResults fileResults) {
		
		UserSS userLogged = UserService.authenticated();
		
		if (userLogged == null) {
			throw new AuthorizationException("Não foi possível salvar os resultados");
		}
		fileResults.setRun_TimeStamp(new Date(System.currentTimeMillis()));
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
		
		newObj.setId_File(null);
		newObj.setDicionario(obj.getDicionario());
		newObj.setDiretorio(obj.getDiretorio());
		newObj.setModelo(obj.getModelo());
		newObj.setModeloDoModulo(obj.getModeloDoModulo());
		newObj.setFileProperties(new FileProperties(obj.getId_File(), null, null, null, null, null, null, null, null, null, null, null));
		newObj.setNomeDoArquivo(obj.getNomeDoArquivo());
		newObj.setProbabilidade(obj.getProbabilidade());
		
	
		return newObj;
	}

}
