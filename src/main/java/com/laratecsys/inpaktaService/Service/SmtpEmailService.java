package com.laratecsys.inpaktaService.Service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Iniciando Serviço de Email...");
		javaMailSender.send(msg);
		LOG.info("Email enviado!");

	}

}
