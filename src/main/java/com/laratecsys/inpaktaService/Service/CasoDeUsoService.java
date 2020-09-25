package com.laratecsys.inpaktaService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosPessoais;
import com.laratecsys.inpaktaService.Repositorie.CasoDeUsoRepositories;
import com.laratecsys.inpaktaService.Repositorie.DadosPessoaisRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;

@Service
public class CasoDeUsoService {
	
	@Autowired
	private CasoDeUsoRepositories casoDeUsoRepositories;
	
	@Autowired
	private DadosPessoaisRepositories dadosPessoaisRepositories;
	
	public CasoDeUso inserirCasoDeUso(CasoDeUso casoDeUso) {
		
		UserSS userLogged = UserService.authenticated();
	
		if (userLogged == null) {
			
			throw new AuthorizationException("Usuario nao esta logado");
		}	
		casoDeUso.setId(null);
		Cliente logged = new Cliente(userLogged.getId(),null,null,null,null);

		 casoDeUso.setCliente(logged);	
		 CasoDeUso newCaso = casoDeUsoRepositories.save(casoDeUso);
		 List<DadosPessoais> newDados = new ArrayList<>();
		 for (DadosPessoais dad : casoDeUso.getDadosPessoais()) {
			 dad.setCasoDeUso(newCaso);
			 newDados.add(dad);
		}
		 dadosPessoaisRepositories.saveAll(newDados);
		 return newCaso;
	}
	
	public List<CasoDeUso> listarCasosDeUso(){
		
		UserSS userLogged = UserService.authenticated();
		
		if (userLogged == null) {
			throw new AuthorizationException("Usuario nao esta logado");
		}
		
		List<CasoDeUso> returned = casoDeUsoRepositories.findAllByClienteId(userLogged.getId());
	
		return returned;
	
	}

}
