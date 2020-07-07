package com.laratecsys.inpaktaService.config;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DatadiscoveryProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Repositorie.DatadiscoveryPropertiesRepositories;
import com.laratecsys.inpaktaService.Repositorie.DbPropertiesRepositories;
import com.laratecsys.inpaktaService.Service.EmailService;
import com.laratecsys.inpaktaService.Service.SmtpEmailService;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	@Autowired
	private ClienteRepositories clienteRepositories;

	@Autowired
	private DbPropertiesRepositories dbPropertiesRepositories;

	@Autowired
	private DatadiscoveryPropertiesRepositories dataDiscoveryRepositoriesRepositories;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		if (!"create".equals(strategy)) {
			Cliente teste = new Cliente(null, "Tiago", "de Lara Ribeiro", "tiagolararibeiro1998@gmail.com",
					pe.encode("1234"));

			DatadiscoveryProperties newDatadiscoveryProperties = new DatadiscoveryProperties(null, 0.6,
					"pt-ner-multi.bin", "en-token.bin", "MYTABLE_TO_IGNORE", 1000, 6, 3, 0,
					"com.strider.datadefender.specialcase.SinDetector.detectSin", "model_generic", "nomes.xml",
					"NERRegex");

			DbProperties newDbProperties = new DbProperties(null, "", "mysql", "com.mysql.jdbc.Driver", "inpakt79_root",
					"1s1@f23ty", "inpakt79_inpaktdb", "jdbc:mysql://inpakta.com.br/inpakt79_inpaktdb", 1, teste,
					newDatadiscoveryProperties);

			clienteRepositories.saveAll(Arrays.asList(teste));

			dataDiscoveryRepositoriesRepositories.saveAll(Arrays.asList(newDatadiscoveryProperties));
			teste.getDbProperties().addAll(Arrays.asList(newDbProperties));
			dbPropertiesRepositories.saveAll(Arrays.asList(newDbProperties));
			return false;
		} else {

			return true;
		}

	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}