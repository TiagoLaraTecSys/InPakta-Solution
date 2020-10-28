package com.laratecsys.inpaktaService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosPessoais;
import com.laratecsys.inpaktaService.Repositorie.DadosPessoaisRepositories;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class DadosPessoaisService {

	@Autowired
	private DadosPessoaisRepositories repositories;
	
	public DadosPessoais find(Integer id) {
		
		Optional<DadosPessoais> obj = repositories.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador. ID:" + id + ", Tipo:" + DadosPessoais.class.getName()));
	}
}
