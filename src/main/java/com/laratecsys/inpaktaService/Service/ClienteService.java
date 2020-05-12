package com.laratecsys.inpaktaService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Dto.ClienteDto;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositories clienteRepositories;

	@Autowired 
	private EmailService emailService;
	
	public Cliente findById(Integer id) {

		Optional<Cliente> newCli = clienteRepositories.findById(id);

		return newCli.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador. ID:" + id + ", Tipo:" + Cliente.class.getName()));
	}

	public Cliente insert(Cliente obj) {
		
		obj.setId(null);
		clienteRepositories.save(obj);
		
		emailService.sendInsertConfirmationHtmlEmail(obj);
		
		return obj;
	}

	public Cliente fromDTO(ClienteDto objDTO) {
		
		return new Cliente(objDTO.getId(),objDTO.getNome(),objDTO.getSobNome(),objDTO.getEmail());
	}

}
