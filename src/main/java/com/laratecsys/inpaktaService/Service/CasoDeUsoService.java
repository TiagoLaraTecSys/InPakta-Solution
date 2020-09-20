package com.laratecsys.inpaktaService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;
import com.laratecsys.inpaktaService.Repositorie.CasoDeUsoRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;

@Service
public class CasoDeUsoService {
	
	@Autowired
	private CasoDeUsoRepositories casoDeUsoRepositories;
	
	public CasoDeUso inserirCasoDeUso(CasoDeUso casoDeUso) {
		
		UserSS userLogged = UserService.authenticated();
	
		if (userLogged == null) {
			
			throw new AuthorizationException("Usuario nao esta logado");
		}	
		casoDeUso.setId(null);
		Cliente logged = new Cliente(userLogged.getId(),null,null,null,null);	
		casoDeUso.setCliente(logged);	
		return casoDeUsoRepositories.save(casoDeUso);
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
