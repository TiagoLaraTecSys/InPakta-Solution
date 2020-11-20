package com.laratecsys.inpaktaService.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasosDeUsoSubject;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;
import com.laratecsys.inpaktaService.Dto.SubjectDTO;
import com.laratecsys.inpaktaService.Enum.TipoSubject;
import com.laratecsys.inpaktaService.Repositorie.CasoDeUsoSubjectRepositories;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Repositorie.SubjectRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.Validations.Utils.ValidatorCode;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepositories subjectRepositories;
		
	@Autowired
	private CasoDeUsoSubjectRepositories casoDeUsoSubjectRepositories;
	
	@Autowired
	private CasoDeUsoService casoDeUsoService;
	
	@Autowired
	private ClienteRepositories clienteRepositories;
	
	@Autowired
	private EmailService emailService;
	
	public Subject find(Integer id) {
		
		Optional<Subject> obj = subjectRepositories.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID:" + id + ", Tipo:" + Subject.class.getName()));
		
	}
	
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
		newSubject.setCasos(subject.getCasos());
		newSubject.setNome(subject.getNome());
		newSubject.setSobNome(subject.getSobNome());
		newSubject.setCpf(subject.getCpf());
		newSubject.setConsideracoes(subject.getConsideracoes());
		
		newSubject.setCodigoValidacao(ValidatorCode.generateCode());
		newSubject = subjectRepositories.save(newSubject);
		
		emailService.sendSubjectCodeVerification(newSubject);
		
		return newSubject;
	}
	
	public void inserindoCasosSubject(SubjectDTO newObj,Integer id) {
		
		Subject obj = find(id);
		System.out.println(id);
		obj.setCasos(newObj.getCasos());

		for(CasosDeUsoSubject x: obj.getCasos()) {
			System.out.println(x.getCasoDeUso().getId());
			System.out.println(x.getConsentimento());
			x.setCasoDeUso(new CasoDeUso(x.getCasoDeUso().getId(), x.getCasoDeUso().getNome(), x.getCasoDeUso().getDescricao()));
			x.setConsentimento(x.getConsentimento());
			x.setSubject(obj);
		}
		casoDeUsoSubjectRepositories.saveAll(obj.getCasos());
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
			
		List<Subject> returned = subjectRepositories.findAll();
		return returned;
	
	}
	
	public Page<Subject> listarSubjectPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		
		UserSS userLogged = UserService.authenticated();
		
		if (userLogged == null) {
			throw new AuthorizationException("Usuário não logado!");
		}
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return subjectRepositories.findAllByClienteId(userLogged.getId(), pageRequest);
		
	}

}
