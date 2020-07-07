package com.laratecsys.inpaktaService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DatadiscoveryProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DTO.DbPropertiesDTO;
import com.laratecsys.inpaktaService.Enum.Perfil;
import com.laratecsys.inpaktaService.Repositorie.DbPropertiesRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class DbPropertiesService {

	@Autowired
	private DbPropertiesRepositories dbPropertiesRepositories;
	
	@Autowired
	private ClienteService clienteService;

	public DbProperties findById(Integer id) {

		Optional<DbProperties> newDbProperties = dbPropertiesRepositories.findById(id);
		
		Integer idUser = newDbProperties.get().getCliente().getId();
		
		UserSS userLogged = UserService.authenticated();
		
		if((userLogged==null || !userLogged.equals(Perfil.ADMIN)) && !userLogged.getId().equals(idUser)) {
			throw new AuthorizationException("Usuário não autorizado");
		}

		return newDbProperties.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador. ID:" + id + ", Tipo:" + DbProperties.class.getName()));
	}

	public DbProperties insert(DbProperties obj) {
		
		obj.setId_db(null);
		obj.setCliente(clienteService.findById(obj.getCliente().getId()));
		dbPropertiesRepositories.save(obj);
		
		//emailService.sendInsertConfirmationHtmlEmail(obj);
		
		return obj;
	}

	public DbProperties fromDTO(DbPropertiesDTO objDto) {
		
		Cliente newCliente = new Cliente(objDto.getCliente_id(), null, null, null,null);
		DatadiscoveryProperties DtProperties = new DatadiscoveryProperties();
		DtProperties.setId(objDto.getDataDiscoveryProperties_id());
		DbProperties newDbProperties = new DbProperties(objDto.getId_db(), objDto.getRepository_name(),
				objDto.getVendor(), objDto.getDriver(), objDto.getUsername(), objDto.getPassword(),
				objDto.getDbschema(),objDto.getUrl(), objDto.getIsActive(), newCliente, DtProperties);
		
		return newDbProperties;
	}

	public List<DbPropertiesDTO> findingAllDbPropertiesByClienteId(){
		
		UserSS userLoged = UserService.authenticated();
		
		if(userLoged==null) {
			throw new AuthorizationException("Usuário não logado!");
		}
		
		List<DbProperties> dbPropertiesList = dbPropertiesRepositories.findByClienteId(new Cliente(userLoged.getId(), null, null, null,null));
		List<DbPropertiesDTO> dbPropertiesDTOList = new ArrayList<>();
	
		for (DbProperties dbProperties : dbPropertiesList) {
			
			dbPropertiesDTOList.add(new DbPropertiesDTO(dbProperties));
		}
		
		return dbPropertiesDTOList;
	}
}
