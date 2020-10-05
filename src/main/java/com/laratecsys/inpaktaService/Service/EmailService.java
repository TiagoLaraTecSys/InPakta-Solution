package com.laratecsys.inpaktaService.Service;

import javax.mail.internet.MimeMessage;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;

public interface EmailService {

	void sendInsertConfirmationHtmlEmail(Cliente cliente);
	
	void sendHtmlEmail(MimeMessage mm);

	void sendSubjectCodeVerification(Subject newSubject);
	
}
