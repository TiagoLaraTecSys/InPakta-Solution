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
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.Subject;

public abstract class AbstractEmailService implements EmailService {

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendNewPasswordEmail(Cliente cliente, String senha) {
		MimeMessage mm;
		
		try {			
			mm = prepareNewPassawordEmail(cliente,senha);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

	protected String htmlFromTemplateAlterarSenha(Cliente cliente, String senha) {
		Context context = new Context();
		context.setVariable("senha", senha);
		context.setVariable("usuario", cliente);

		return templateEngine.process("email/alteracaoDeSenha", context);
	}
	
	protected MimeMessage prepareNewPassawordEmail(Cliente cliente, String senha) throws MessagingException {

		MimeMessage newMM = javaMailSender.createMimeMessage();
		MimeMessageHelper newMMH = new MimeMessageHelper(newMM, true);

		newMMH.setTo(cliente.getEmail());
		newMMH.setFrom(sender);
		newMMH.setSubject("Recuperação de senha");
		newMMH.setSentDate(new Date(System.currentTimeMillis()));

		newMMH.setText(htmlFromTemplateAlterarSenha(cliente, senha), true);

		return newMM;
	}
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

	@Override
	public void sendSubjectCodeVerification(Subject subject) {

		MimeMessage mm;

		try {
			mm = prepareMimeMessage(subject);
			sendHtmlEmail(mm);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sendSubjectConfirmation(Subject updatedSubject) {

		MimeMessage mm;

		try {
			mm = prepareMimeMessageConfirmSubject(updatedSubject);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	protected String htmlFromTemplateCliente(Cliente obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		return templateEngine.process("email/confirmacaoEmail", context);

	}

	protected String htmlFromTemplateSubject(Subject obj) {
		Context context = new Context();
		context.setVariable("subject", obj);
		return templateEngine.process("email/codigoValidador", context);

	}

	protected String htmlFromTemplateConfirmSubject(Subject update) {
		Context context = new Context();
		context.setVariable("subject", update);
		context.setVariable("tipo", update.getSubjectTipo().getDescricao());
		return templateEngine.process("email/codigoValidadorConfirmacao", context);
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

	protected MimeMessage prepareMimeMessage(Subject obj) throws MessagingException {

		MimeMessage newMM = javaMailSender.createMimeMessage();
		MimeMessageHelper newMMH = new MimeMessageHelper(newMM, true);

		newMMH.setTo(obj.getEmail());
		newMMH.setFrom(sender);

		newMMH.setSubject("CÓDIGO DE VERIFICAÇÃO");
		newMMH.setSentDate(new Date(System.currentTimeMillis()));

		newMMH.setText(htmlFromTemplateSubject(obj), true);

		return newMM;

	}

	protected MimeMessage prepareMimeMessageConfirmSubject(Subject updated) throws MessagingException {

		MimeMessage newMM = javaMailSender.createMimeMessage();
		MimeMessageHelper newMMH = new MimeMessageHelper(newMM, true);

		newMMH.setTo(updated.getEmail());
		newMMH.setFrom(sender);

		newMMH.setSubject("Confirmação do Pedido");
		newMMH.setSentDate(new Date(System.currentTimeMillis()));

		newMMH.setText(htmlFromTemplateConfirmSubject(updated), true);

		return newMM;
	}

}
