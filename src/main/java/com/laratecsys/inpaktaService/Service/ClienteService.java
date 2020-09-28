package com.laratecsys.inpaktaService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Dto.ClienteDto;
import com.laratecsys.inpaktaService.Dto.ClienteUpdateDto;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositories clienteRepositories;

	@Autowired
	private EmailService emailService;

	@Autowired
	private BCryptPasswordEncoder pe;

	public Cliente findById(Integer id) {

		Optional<Cliente> newCli = clienteRepositories.findById(id);

		return newCli.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador. ID:" + id + ", Tipo:" + Cliente.class.getName()));
	}

	public Cliente findByEmail(String email) {

		Cliente novoCliente = new Cliente();

		novoCliente = clienteRepositories.findByEmail(email);

		return novoCliente;
	}

	public Cliente insert(Cliente clienteParametro) {

		Cliente novoCliente = findByEmail(clienteParametro.getEmail());

		if (novoCliente != null) {
			throw new AuthorizationException("Email já existente!");
		}

		clienteParametro.setId(null);
		clienteRepositories.save(clienteParametro);
		
		emailService.sendInsertConfirmationHtmlEmail(clienteParametro);

		return clienteParametro;
	}

	public Cliente update(Cliente clienteParametro) {
		
		Cliente newObj = findById(clienteParametro.getId());
		updateData(newObj, clienteParametro);
		return clienteRepositories.save(newObj);
		
	}
	public Cliente fromDTO(ClienteUpdateDto objDTO) {
		Cliente newCliente = new Cliente(null,objDTO.getNome(), objDTO.getSobNome(), objDTO.getEmail(),
				null);
		
		if (objDTO.getAutomated()==null)
		{
			newCliente.setAutomated(false);
		}else 
		{ newCliente.setAutomated(objDTO.getAutomated());}
		
		newCliente.setOrganizacao(objDTO.getOrganizacao());
		
		newCliente.setSubDominio(objDTO.getSubDominio());
		newCliente.setCor(objDTO.getCor());
		newCliente.setIcone(objDTO.getIcone());
		
		return newCliente;
	}
	
	public Cliente fromDTO(ClienteDto objDTO) {
		Cliente newCliente = new Cliente(null,objDTO.getNome(), objDTO.getSobNome(), objDTO.getEmail(),
				pe.encode(objDTO.getSenha()));
		
		if (objDTO.getAutomated()==null)
		{
			newCliente.setAutomated(false);
		}else 
		{ newCliente.setAutomated(objDTO.getAutomated());}
		
		newCliente.setOrganizacao(objDTO.getOrganizacao());
		return newCliente;
	}


	public void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setAutomated(obj.getAutomated());
		newObj.setSobNome(obj.getSobNome());
		newObj.setOrganizacao(obj.getOrganizacao());
		newObj.setSubDominio(obj.getSubDominio());
		newObj.setCor(obj.getCor());
		newObj.setIcone(obj.getCor());
	}
	public List<Cliente> findAll(){
		
		UserSS userLogged = UserService.authenticated();
		List<Cliente> newCli = clienteRepositories.findAll();
		if (newCli==null) {
			throw new ObjectNotFoundException("Não existe emails cadastrados!!");
		}else {
			return clienteRepositories.findAll();
		}
	}

}
