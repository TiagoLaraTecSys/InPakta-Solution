package com.laratecsys.inpaktaService.Resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DTO.DbPropertiesDTO;
import com.laratecsys.inpaktaService.Service.DbPropertiesService;

@RestController
@RequestMapping(value = "/dbproperties")
public class DbPropertiesResources {

	@Autowired
	private DbPropertiesService dbPropertiesService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DbProperties> findById(@PathVariable Integer id) {
		
		DbProperties obj = dbPropertiesService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody DbPropertiesDTO objDto){
		
		DbProperties obj = dbPropertiesService.fromDTO(objDto);
		obj = dbPropertiesService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId_db()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
