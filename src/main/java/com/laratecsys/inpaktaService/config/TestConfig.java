package com.laratecsys.inpaktaService.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DatadiscoveryProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Repositorie.DatadiscoveryPropertiesRepositories;
import com.laratecsys.inpaktaService.Repositorie.DbPropertiesRepositories;
import com.laratecsys.inpaktaService.Repositorie.FilePropertiesRepositories;
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
	private DatadiscoveryPropertiesRepositories dataDiscoveryRepositoriesRepositories;
	
	@Autowired
	private FilePropertiesRepositories filePropertiesRepositories;
	
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
		
		DatadiscoveryProperties newDatadiscoveryProperties = new DatadiscoveryProperties(null,0.6, "pt-ner-multi.bin",
				"en-token.bin", "MYTABLE_TO_IGNORE", 1000, 6, 3, 0,
				"com.strider.datadefender.specialcase.SinDetector.detectSin", "model_generic", "nomes.xml", "NERRegex");

		DbProperties newDbProperties = new DbProperties(null, "", "mysql", "com.mysql.jdbc.Driver", "inpakt79_root",
				"1s1@f23ty", "inpakt79_inpaktdb", "jdbc:mysql://inpakta.com.br/inpakt79_inpaktdb", 1, teste,newDatadiscoveryProperties);

		FileProperties newFileProperties = new FileProperties(null,"0.6", "pt-ner-multi.bin", "en-token.bin", "model_generic", "C:/Users/larat/OneDrive/Documents/InPakta/teste", 
				"excluded_files.txt","nomdes.xml", "txt, TXT, docx,doc,PDF,pdf,html,css", "NEREntropy",new Date(System.currentTimeMillis()),teste);
		
		clienteRepositories.saveAll(Arrays.asList(teste));

		dataDiscoveryRepositoriesRepositories.saveAll(Arrays.asList(newDatadiscoveryProperties));
		teste.getDbProperties().addAll(Arrays.asList(newDbProperties));
		teste.getFileProperties().addAll(Arrays.asList(newFileProperties));
		filePropertiesRepositories.saveAll(Arrays.asList(newFileProperties));
		dbPropertiesRepositories.saveAll(Arrays.asList(newDbProperties));

	}

}
