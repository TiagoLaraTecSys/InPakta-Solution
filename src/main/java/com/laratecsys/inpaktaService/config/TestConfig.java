package com.laratecsys.inpaktaService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.laratecsys.inpaktaService.Service.EmailService;
import com.laratecsys.inpaktaService.Service.SmtpEmailService;

@Configuration
@Profile(value = "test")
public class TestConfig {
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
