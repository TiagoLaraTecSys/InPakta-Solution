package com.laratecsys.inpaktaService.Resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosPessoais;
import com.laratecsys.inpaktaService.Dto.DadosPessoaisDTO;
import com.laratecsys.inpaktaService.Service.DadosPessoaisService;

@RestController
@RequestMapping(value = "/dadospessoais")
public class DadosPessoaisResource {

	@Autowired
	private DadosPessoaisService service;
	
	@RequestMapping(method=RequestMethod.POST)
	private ResponseEntity<DadosPessoais> inserir(@Validated @RequestBody DadosPessoaisDTO objDTO){
		
		DadosPessoais obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	private ResponseEntity<List<DadosPessoais>> listar(){
		
		List<DadosPessoais> obj = service.listAll();
		
		return ResponseEntity.ok().body(obj);
	}
}
