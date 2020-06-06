package com.laratecsys.inpaktaService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DataResult;
import com.laratecsys.inpaktaService.Dto.ClienteDto;
import com.laratecsys.inpaktaService.Repositorie.DataResultRepositories;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class DataResultService {

	@Autowired
	private DataResultRepositories dataResultRepositories;

	@Autowired 
	private EmailService emailService;
	
	public DataResult findById(Integer id) {

		Optional<DataResult> newCli = dataResultRepositories.findById(id);

		return newCli.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador. ID:" + id + ", Tipo:" + DataResult.class.getName()));
	}

	public DataResult insert(DataResult obj) {
		
		obj.setId_data(null);
		dataResultRepositories.save(obj);
		return obj;
	}

	public Cliente fromDTO(ClienteDto objDTO) {
		
		return new Cliente(objDTO.getId(),objDTO.getNome(),objDTO.getSobNome(),objDTO.getEmail());
	}

}
