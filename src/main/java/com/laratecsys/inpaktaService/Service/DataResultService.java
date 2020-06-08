package com.laratecsys.inpaktaService.Service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Redatasense.DataResult;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DTO.DataResultDTO;
import com.laratecsys.inpaktaService.Repositorie.DataResultRepositories;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class DataResultService {

	@Autowired
	private DataResultRepositories dataResultRepositories;
	
	@Autowired
	private DbPropertiesService dbPropertiesService;

	public DataResult findById(Integer id) {

		Optional<DataResult> newCli = dataResultRepositories.findById(id);

		return newCli.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador. ID:" + id + ", Tipo:" + DataResult.class.getName()));
	}

	public DataResult insert(DataResult obj) {
		
		obj.setId_data(null);
		obj.setRun_timestamp(new Date(System.currentTimeMillis()));
		obj.setDbProperties(dbPropertiesService.findById(obj.getDbProperties().getId_db()));
		dataResultRepositories.save(obj);
		return obj;
	}

	public DataResult fromDTO(DataResultDTO objDTO) {
		
		
		DbProperties dbProperties = new DbProperties(objDTO.getId_db(), null, null, null, null, null, null, null, null, null);
		
		return new DataResult(null, objDTO.getRun_id(), null, objDTO.getSchema_name(), 
				objDTO.getTable_name(), objDTO.getColumn_name(), objDTO.getProbability(), 
				objDTO.getModel(), objDTO.getModel_mode(), objDTO.getDictionary(),
				objDTO.getNum_rows(), objDTO.getScore(), objDTO.getSample_data(), dbProperties);
	}

}
