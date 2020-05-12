package com.laratecsys.inpaktaService.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.laratecsys.inpaktaService.Service.EmailService;
import com.laratecsys.inpaktaService.Service.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDevDatabase() throws ParseException {
		
		if (!"create".equals(strategy)) {
			return false;
		}else {

			return true;
		}
	
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
