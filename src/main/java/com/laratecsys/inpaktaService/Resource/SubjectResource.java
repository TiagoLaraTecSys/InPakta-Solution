package com.laratecsys.inpaktaService.Resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;
import com.laratecsys.inpaktaService.Dto.SubjectDTO;
import com.laratecsys.inpaktaService.Service.SubjectService;

import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping(value = "/subject")
public class SubjectResource {

	@Autowired
	private SubjectService service;
	
	@ApiOperation("Inserção de uma nova requisição")
	@RequestMapping(method = RequestMethod.POST)
	private	ResponseEntity<Object> inserirSubject(@Valid @RequestBody SubjectDTO subjectDTO){
		
		
		Subject subject = service.inserirSubject(subjectDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(subject.getId()).toUri();
		
		return ResponseEntity.ok().body(subject.getCodigoValidacao());
	}
	
	@ApiOperation("Listagem dos casos de uso")
	@RequestMapping(value = "/listar",method = RequestMethod.GET)
	private ResponseEntity<Object> listarSubject(@RequestParam String subDominio){
		
		List<Subject> listaSubject = service.listarSubject(subDominio);
	
		return ResponseEntity.ok().body(listaSubject);
		
	}
	
	
}
