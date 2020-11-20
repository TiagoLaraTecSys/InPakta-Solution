package com.laratecsys.inpaktaService.Resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;
import com.laratecsys.inpaktaService.Dto.ClienteUpdateDto;
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
		
		return ResponseEntity.created(uri).body(subject.getCodigoValidacao());
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	private ResponseEntity<Object> atualizarSubject(@RequestParam String validatecode ){
		
		service.validateCode(validatecode);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Listagem dos subjects")
	@RequestMapping(value = "/listar",method = RequestMethod.GET)
	private ResponseEntity<Object> listarSubject(@RequestParam String subDominio){
		
		List<Subject> listaSubject = service.listarSubject(subDominio);
	
		return ResponseEntity.ok().body(listaSubject);
		
	}
	
	@ApiOperation("Listagem dos pedidos com paginação")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	private ResponseEntity<Page<Subject>> subjectPage(
			@RequestParam(defaultValue = "0",name = "page") Integer page,
			@RequestParam(defaultValue = "10", name = "linesPerPage") Integer linesPerPage,
			@RequestParam(defaultValue = "id", name="orderBy") String orderBy,
			@RequestParam(defaultValue = "DESC", name="direction") String direction){
		
		Page<Subject> list = service.listarSubjectPage(page, linesPerPage, direction, orderBy);
		
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value="Atualização de subject")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody SubjectDTO objDTO, @PathVariable Integer id){

		service.inserindoCasosSubject(objDTO,id);
		
		return ResponseEntity.noContent().build();
	}
}
