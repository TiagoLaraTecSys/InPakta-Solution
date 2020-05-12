package com.laratecsys.inpaktaService.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.laratecsys.inpaktaService.Service.EmailService;
import com.laratecsys.inpaktaService.Service.SmtpEmailService;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		if (!"create".equals(strategy)) {
			return false;
		} else {

			return true;
		}

	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}