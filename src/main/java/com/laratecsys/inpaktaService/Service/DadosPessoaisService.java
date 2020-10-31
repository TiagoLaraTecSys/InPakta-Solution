package com.laratecsys.inpaktaService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosPessoais;
import com.laratecsys.inpaktaService.Dto.DadosPessoaisDTO;
import com.laratecsys.inpaktaService.Repositorie.DadosPessoaisRepositories;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class DadosPessoaisService {

	@Autowired
	private DadosPessoaisRepositories repositories;
	
	public DadosPessoais insert(DadosPessoais obj) {
		
		obj.setId(null);
		
		DadosPessoais newObj = repositories.findByDado(obj.getDado());
		
		if(newObj!=null) {
			throw new AuthorizationException("Dado pessoal ja existe!");
		}
		
		
		return repositories.save(obj);
	}
	
	public DadosPessoais find(Integer id) { 
		
		Optional<DadosPessoais> obj = repositories.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador. ID:" + id + ", Tipo:" + DadosPessoais.class.getName()));
	}
	
	public List<DadosPessoais> listAll(){
		
		List<DadosPessoais> obj = repositories.findAllGroupByDado();
		return obj;
	}
	
	public DadosPessoais fromDTO(DadosPessoaisDTO objDTO) {
		
		DadosPessoais obj = new DadosPessoais(null, objDTO.getDado());
		
		return obj;
	}
}
