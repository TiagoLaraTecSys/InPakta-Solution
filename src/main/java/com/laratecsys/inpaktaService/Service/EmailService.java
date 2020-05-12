package com.laratecsys.inpaktaService.Service;

import javax.mail.internet.MimeMessage;

import com.laratecsys.inpaktaService.Domain.Cliente;

public interface EmailService {

	void sendInsertConfirmationHtmlEmail(Cliente cliente);
	
	void sendHtmlEmail(MimeMessage mm);
}
