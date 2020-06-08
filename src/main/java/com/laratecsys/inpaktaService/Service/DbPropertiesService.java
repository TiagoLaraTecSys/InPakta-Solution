package com.laratecsys.inpaktaService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DTO.DbPropertiesDTO;
import com.laratecsys.inpaktaService.Repositorie.DbPropertiesRepositories;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class DbPropertiesService {

	@Autowired
	private DbPropertiesRepositories dbPropertiesRepositories;
	
	@Autowired
	private ClienteService clienteService;

	public DbProperties findById(Integer id) {

		Optional<DbProperties> newCli = dbPropertiesRepositories.findById(id);

		return newCli.orElseThrow(() -> new ObjectNotFoundException(
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
		
		Cliente newCliente = new Cliente(objDto.getCliente_id(), null, null, null);
		DbProperties newDbProperties = new DbProperties(objDto.getId_db(), objDto.getRepository_name(),
				objDto.getVendor(), objDto.getDriver(), objDto.getUsername(), objDto.getPassword(),
				objDto.getDbschema(),objDto.getUrl(), objDto.getIsActive(), newCliente);
		
		return newDbProperties;
	}


}
