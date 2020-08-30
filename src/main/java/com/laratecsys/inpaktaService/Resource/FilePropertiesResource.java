package com.laratecsys.inpaktaService.Resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DTO.FilePropertiesDTO;
import com.laratecsys.inpaktaService.Service.FilePropertiesService;

@RestController
@RequestMapping(value = "/fileproperties")
public class FilePropertiesResource {

	@Autowired
	private FilePropertiesService filePropertiesService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FileProperties> findById(@PathVariable Integer id) {
		
		FileProperties obj = filePropertiesService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody FilePropertiesDTO filePropertiesDTO){
		

		FileProperties obj = filePropertiesService.insert(filePropertiesDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<FileProperties>> listingDbProperties(){
		
		List<FileProperties> filePropertiesList = filePropertiesService.findingAllDbPropertiesByClienteId();
		return ResponseEntity.ok().body(filePropertiesList);
	}
	
}
