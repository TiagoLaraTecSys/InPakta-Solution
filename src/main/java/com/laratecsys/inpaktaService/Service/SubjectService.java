package com.laratecsys.inpaktaService.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;
import com.laratecsys.inpaktaService.Dto.SubjectDTO;
import com.laratecsys.inpaktaService.Enum.TipoSubject;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Repositorie.SubjectRepositories;
import com.laratecsys.inpaktaService.Service.Validations.Utils.ValidatorCode;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepositories subjectRepositories;
		
	@Autowired
	private ClienteRepositories clienteRepositories;
	
	@Autowired
	private EmailService emailService;
	
	public Subject inserirSubject(SubjectDTO subject) {
			
		Subject newSubject = new Subject();
		newSubject.setId(null);
		Cliente logged = clienteRepositories.findBySubDominio(subject.getSubDominio());
		newSubject.setCliente(logged);
		newSubject.setData(new Date(System.currentTimeMillis()));
		newSubject.setEmail(subject.getEmail());
		newSubject.setFeito(false);
		newSubject.setValidado(false);
		newSubject.setSubjectTipo(TipoSubject.toEnum(subject.getTipo()));
		
		newSubject.setCodigoValidacao(ValidatorCode.generateCode());
		subjectRepositories.save(newSubject);
		
		emailService.sendSubjectCodeVerification(newSubject);
		
		return newSubject;
	}
	
	
	public Subject validateCode(String validatecode) {
		
	
		Subject newObj = subjectRepositories.findByCodigoValidacao(validatecode);
		
		if (newObj == null) {
			throw new ObjectNotFoundException("Código não encontrado!");
		}
		
		newObj.setValidado(true);
		emailService.sendSubjectConfirmation(newObj);
		return subjectRepositories.save(newObj);
	}

	public List<Subject> listarSubject(String subDominio){
			
		List<Subject> returned = clienteRepositories.findAllBySubDominio(subDominio);	
		return returned;
	
	}

}
