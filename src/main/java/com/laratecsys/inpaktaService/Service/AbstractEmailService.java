package com.laratecsys.inpaktaService.Service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.laratecsys.inpaktaService.Domain.Cliente;

public abstract class AbstractEmailService implements EmailService {

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendInsertConfirmationHtmlEmail(Cliente cliente) {

		MimeMessage mm;
		try {
			mm = prepareMimeMessage(cliente);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	protected String htmlFromTemplateCliente(Cliente obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		return templateEngine.process("/email/confirmacaoEmail", context);

	}

	protected MimeMessage prepareMimeMessage(Cliente obj) throws MessagingException {

		MimeMessage newMM = javaMailSender.createMimeMessage();
		MimeMessageHelper newMMH = new MimeMessageHelper(newMM, true);

		newMMH.setTo(obj.getEmail());
		newMMH.setFrom(sender);
		newMMH.setSubject("Bem vindo a inPakta! " + obj.getNome() + " " + obj.getSobNome());
		newMMH.setSentDate(new Date(System.currentTimeMillis()));

		newMMH.setText(htmlFromTemplateCliente(obj), true);

		return newMM;

	}

}