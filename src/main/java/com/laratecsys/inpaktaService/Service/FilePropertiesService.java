package com.laratecsys.inpaktaService.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DTO.FilePropertiesDTO;
import com.laratecsys.inpaktaService.Enum.Perfil;
import com.laratecsys.inpaktaService.Repositorie.FilePropertiesRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;
import com.laratecsys.inpaktaService.Service.exception.ConstraitException;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class FilePropertiesService {

	@Autowired
	private FilePropertiesRepositories filePropertiesRepositories;
	
	@Autowired
	private ClienteService clienteService;

	public FileProperties findById(Integer id) {

		Optional<FileProperties> newFilePropertiesRepositories = filePropertiesRepositories.findById(id);
		
		Integer idUser = newFilePropertiesRepositories.get().getCliente().getId();
		
		UserSS userLogged = UserService.authenticated();
		
		if((userLogged==null || !userLogged.equals(Perfil.ADMIN)) && !userLogged.getId().equals(idUser)) {
			throw new AuthorizationException("Usuário não autorizado");
		}

		return newFilePropertiesRepositories.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador. ID:" + id + ", Tipo:" + FileProperties.class.getName()));
	}

	public FileProperties insert(FilePropertiesDTO obj) {
		
				
		UserSS userLogged = UserService.authenticated();
		
		if (userLogged==null) {
			throw new AuthorizationException("Usuário não aturizado para inserir novo diretório");
		}
		
		FileProperties fileProperties = fromDTO(obj);
		
		fileProperties.setId(null);
		fileProperties.setCliente(clienteService.findById(userLogged.getId()));
		
		try {
			
				filePropertiesRepositories.save(fileProperties);
			
		}catch (DataIntegrityViolationException e) {
			
			throw new ConstraitException("Não foi possível encontrar a referência: " + e.getMessage());
			
		}
		
		//emailService.sendInsertConfirmationHtmlEmail(obj);
		return fileProperties;
		
	}

	public FileProperties fromDTO(FilePropertiesDTO objDto) {
		
		
		FileProperties newFileProperties = new FileProperties(null, objDto.getLimiteDeProbabilidade(), objDto.getModeloGenerico(), objDto.getToken(),objDto.getModelos(),
				objDto.getDiretorios(),objDto.getArquivosExcluidos(), objDto.getPastaDoDicionario(), objDto.getExtensaoArquivo(), objDto.getNERmodel(),new Date(System.currentTimeMillis()), null);
		
		return newFileProperties;
	}

	public List<FileProperties> findingAllDbPropertiesByClienteId(){
		
		UserSS userLoged = UserService.authenticated();
		
		if(userLoged==null) {
			throw new AuthorizationException("Usuário não logado!");
		}
		
		List<FileProperties> filePropertiesList = filePropertiesRepositories.findByClienteId(new Cliente(userLoged.getId(), null, null, null,null));

		return filePropertiesList;
	}

	public FileProperties update(FileProperties fileProperties) {
		
		FileProperties obj = filePropertiesRepositories.getOne(fileProperties.getId());
		updateData(obj,fileProperties);
		return filePropertiesRepositories.save(obj);
	}

	private void updateData(FileProperties newObj, FileProperties fileProperties) {

		newObj.setLimiteDeProbabilidade(fileProperties.getLimiteDeProbabilidade());
		//newObj.setArquivosExcluidos(fileProperties.getArquivosExcluidos());
		newObj.setDiretorios(fileProperties.getDiretorios());
		newObj.setExtensaoArquivo(fileProperties.getExtensaoArquivo());
		newObj.setNERmodel(fileProperties.getNERmodel());
		
	}
}
