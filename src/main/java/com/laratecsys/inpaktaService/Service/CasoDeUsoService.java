package com.laratecsys.inpaktaService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosPessoais;
import com.laratecsys.inpaktaService.Repositorie.CasoDeUsoRepositories;
import com.laratecsys.inpaktaService.Repositorie.DadosPessoaisRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class CasoDeUsoService {
	
	@Autowired
	private CasoDeUsoRepositories casoDeUsoRepositories;
	
	@Autowired
	private DadosPessoaisRepositories dadosPessoaisRepositories;
	
	
	public CasoDeUso find(Integer id) {
		
		UserSS userLogged = UserService.authenticated();
		Optional<CasoDeUso> caso = casoDeUsoRepositories.findById(id);
		
		if(!caso.get().getCliente().getId().equals(userLogged.getId())) {
			throw new AuthorizationException("Usuário não autorizado");
		}
		
		
		return caso.orElseThrow(() -> 
			new ObjectNotFoundException("Caso de Uso não encontrado"));
	}
	
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
	
	
	public void deletarCasoDeUso(Integer id) {
		
		
		casoDeUsoRepositories.deleteById(id);
	}
	
	public List<CasoDeUso> listarCasosDeUso(){
		
		UserSS userLogged = UserService.authenticated();
		
		if (userLogged == null) {
			throw new AuthorizationException("Usuario nao esta logado");
		}
		
		List<CasoDeUso> returned = casoDeUsoRepositories.findAllByClienteId(userLogged.getId());
	
		return returned;
	
	}
	
	public Page<CasoDeUso> findAllPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		UserSS userLogged = UserService.authenticated();
		
		
		
		return casoDeUsoRepositories.findAllByClienteId(userLogged.getId(), pageRequest);
	}

}
