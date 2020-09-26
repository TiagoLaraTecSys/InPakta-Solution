package com.laratecsys.inpaktaService.Resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Dto.ClienteDto;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.ClienteService;
import com.laratecsys.inpaktaService.Service.UserService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResources {

	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(value="Busca de um cliente pelo Id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(value="/infos", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByToken(){
		
		UserSS userLogged = UserService.authenticated();
		
		Cliente obj = clienteService.findById(userLogged.getId());
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Cadastro de um novo cliente")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClienteDto objDTO){
		
		Cliente obj = clienteService.fromDTO(objDTO);
		obj = clienteService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value="Atualização de usuáro")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDto objDTO, @PathVariable Integer id){
		Cliente obj = clienteService.fromDTO(objDTO);
		obj.setId(id);
		obj = clienteService.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@ApiIgnore()
	@RequestMapping(value = "/emails/andre", method = RequestMethod.GET)
	public ResponseEntity<List<String>> listingAllClientEmail(){
		
		List<String> objEmails = new ArrayList<>();
		
		for (Cliente cliente : clienteService.findAll()) {
			
			objEmails.add(cliente.getEmail());
		}
		
		return ResponseEntity.ok().body(objEmails);
	}
	
}
