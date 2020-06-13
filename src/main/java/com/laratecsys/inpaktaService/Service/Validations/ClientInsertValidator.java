package com.laratecsys.inpaktaService.Service.Validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Dto.NewClientDTO;
import com.laratecsys.inpaktaService.Enum.TipoCliente;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Repositorie.Exceptions.FieldMessage;
import com.laratecsys.inpaktaService.Service.Validations.Utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClienteInsert, NewClientDTO> {

	@Autowired
	private ClienteRepositories repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
		
	}
	@Override
	public boolean isValid(NewClientDTO objDTO, ConstraintValidatorContext context) {


		List<FieldMessage> errors = new ArrayList<>();
		
		if (objDTO.getTipo().equals(TipoCliente.PESSOA_FISICA.getCod()) && !BR.isValidSsn(objDTO.getCpfOuCnpj())) {
			errors.add(new FieldMessage("CpfOuCnpj", "CPF inválido", objDTO.getCpfOuCnpj()));
		}
		
		if (objDTO.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCod()) && !BR.isValidTfn(objDTO.getCpfOuCnpj())) {
			errors.add(new FieldMessage("CpfOuCnpj", "CNPJ inválido", objDTO.getCpfOuCnpj()));
		}
		
		Cliente aux = repo.findByEmail(objDTO.getEmail());
		if (aux != null) {
			errors.add(new FieldMessage("Email", "Email ja existe!", objDTO.getEmail()));  
		}
		
		for (FieldMessage fieldMessage : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fieldMessage.getMessage()).addPropertyNode(fieldMessage.getFieldName())
			.addConstraintViolation();
			
			
		}
		return errors.isEmpty();
	}
	
	

}
