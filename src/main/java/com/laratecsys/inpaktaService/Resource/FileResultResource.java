package com.laratecsys.inpaktaService.Resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileResults;
import com.laratecsys.inpaktaService.Dto.FileResultsDTO;
import com.laratecsys.inpaktaService.Service.FileResultService;

@RestController
@RequestMapping(value = "/fileresults")
public class FileResultResource {

	@Autowired
	private FileResultService fileResultsService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody FileResultsDTO fileResultsDTO){
		
		FileResults newObj = fileResultsService.fromDTO(fileResultsDTO);
		
		FileResults obj = fileResultsService.insert(newObj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId_File()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<FileResults>> listingDbProperties(){
		
		List<FileResults> fileResultsList = fileResultsService.findingAllFileResultsByClienteId();
		return ResponseEntity.ok().body(fileResultsList);
	}
	
}
