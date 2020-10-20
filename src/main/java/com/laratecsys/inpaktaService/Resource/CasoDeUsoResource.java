package com.laratecsys.inpaktaService.Resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;
import com.laratecsys.inpaktaService.Service.CasoDeUsoService;

import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping(value = "/casodeuso")
public class CasoDeUsoResource {

	@Autowired
	private CasoDeUsoService service;
	
	@ApiOperation("Inserção de um novo caso de uso")
	@RequestMapping(method = RequestMethod.POST)
	private	ResponseEntity<Object> inserirCasoDeUso(@RequestBody CasoDeUso casoDeUso){
		
		
		casoDeUso = service.inserirCasoDeUso(casoDeUso);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(casoDeUso.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Listagem dos casos de uso")
	@RequestMapping(value = "/listar",method = RequestMethod.GET)
	private ResponseEntity<Object> listarCasosDeUso(){
		
		List<CasoDeUso> casosDeUso = service.listarCasosDeUso();
	
		return ResponseEntity.ok().body(casosDeUso);
		
	}
	
	@RequestMapping(value= "/page", method = RequestMethod.GET)
	private ResponseEntity<Page<CasoDeUso>> pageCasosDeUso(
			@RequestParam(defaultValue = "0",name = "page") Integer page,
			@RequestParam(defaultValue = "10", name = "linesPerPage") Integer linesPerPage,
			@RequestParam(defaultValue = "id", name="orderBy") String orderBy,
			@RequestParam(defaultValue = "DESC", name="direction") String direction){
		
		Page<CasoDeUso> list = service.findAllPage(page, linesPerPage, direction, orderBy);
		
		return ResponseEntity.ok().body(list);	
	}
	
}
