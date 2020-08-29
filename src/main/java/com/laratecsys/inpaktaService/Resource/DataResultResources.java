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

import com.laratecsys.inpaktaService.Domain.Redatasense.DataResult;
import com.laratecsys.inpaktaService.Domain.Redatasense.DTO.DataResultDTO;
import com.laratecsys.inpaktaService.Service.DataResultService;

@RestController
@RequestMapping(value = "/dataresult")
public class DataResultResources {

	@Autowired
	private DataResultService dataResultService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DataResult> findById(@PathVariable Integer id) {
		
		DataResult obj = dataResultService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody DataResultDTO objDto){
	
		DataResult obj = dataResultService.fromDTO(objDto);
		obj = dataResultService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId_data()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public ResponseEntity<List<DataResult>> findAllByClientId(){
		
		List<DataResult> dataResultAll = dataResultService.findAllByClienteId();
		
		return ResponseEntity.accepted().body(dataResultAll);
	}
	
}
