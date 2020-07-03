package com.laratecsys.inpaktaService.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Repositorie.DbPropertiesRepositories;
import com.laratecsys.inpaktaService.Service.EmailService;
import com.laratecsys.inpaktaService.Service.SmtpEmailService;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepositories clienteRepositories;
	
	@Autowired
	private DbPropertiesRepositories dbPropertiesRepositories;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente teste = new Cliente(null, "Tiago", "de Lara Ribeiro", "tiagolararibeiro1998@gmail.com",
				pe.encode("1234"));

		DbProperties newDbProperties = new DbProperties(null, "", "mysql", "com.mysql.jdbc.Driver", "inpakt79_root",
				"1s1@f23ty", "inpakt79_inpaktdb", "jdbc:mysql://inpakta.com.br/inpakt79_inpaktdb", 1, teste);

		teste.getDbProperties().addAll(Arrays.asList(newDbProperties));

		clienteRepositories.saveAll(Arrays.asList(teste));

		dbPropertiesRepositories.saveAll(Arrays.asList(newDbProperties));
	}

}
