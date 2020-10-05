package com.laratecsys.inpaktaService.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;
import com.laratecsys.inpaktaService.Dto.SubjectDTO;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Repositorie.SubjectRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepositories subjectRepositories;
		
	@Autowired
	private ClienteRepositories clienteRepositories;
	
	public Subject inserirSubject(SubjectDTO subject) {
			
		Subject newSubject = new Subject();
		newSubject.setId(null);
		Cliente logged = clienteRepositories.findBySubDominio(subject.getSubDominio());
		newSubject.setCliente(logged);
		newSubject.setData(new Date(System.currentTimeMillis()));
		newSubject.setEmail(subject.getEmail());
		newSubject.setFeito(false);
		newSubject.setValidado(false);
		
		
		 return subjectRepositories.save(newSubject);
	}
	
	public List<Subject> listarCasosDeUso(String subDominio){
			
		List<Subject> returned = clienteRepositories.findAllBySubDominio(subDominio);	
		return returned;
	
	}

}
