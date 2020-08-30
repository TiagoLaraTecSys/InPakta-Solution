package com.laratecsys.inpaktaService.config;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DatadiscoveryProperties;
import com.laratecsys.inpaktaService.Domain.Redatasense.FileProperties;
import com.laratecsys.inpaktaService.Repositorie.DatadiscoveryPropertiesRepositories;
import com.laratecsys.inpaktaService.Repositorie.FilePropertiesRepositories;
import com.laratecsys.inpaktaService.Service.EmailService;
import com.laratecsys.inpaktaService.Service.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Autowired
	private DatadiscoveryPropertiesRepositories dataRepo;
	
	@Autowired
	private FilePropertiesRepositories filePropertiesRepositories;
	@Bean
	public boolean instantiateDevDatabase() throws ParseException {

		if ("update".equals(strategy)) {
			/*DatadiscoveryProperties newDatadiscoveryProperties = new DatadiscoveryProperties(null, 0.6,
					"pt-ner-multi.bin", "en-token.bin", "MYTABLE_TO_IGNORE", 1000, 6, 3, 0,
					"com.strider.datadefender.specialcase.SinDetector.detectSin", "model_generic", "nomes.xml",
					"NERRegex");*/
			//dataRepo.save(newDatadiscoveryProperties);
			
			//FileProperties newFileProperties = new FileProperties(null,"0.6", "pt-ner-multi.bin", "en-token.bin", "model_generic", "C:/Users/larat/OneDrive/Documents/InPakta/teste", 
			//		"excluded_files.txt","nomdes.xml", "txt, TXT, docx,doc,PDF,pdf,html,css", "NEREntropy",new Date(System.currentTimeMillis()),new Cliente(105, null, null, null, null));
			
			//filePropertiesRepositories.saveAll(Arrays.asList(newFileProperties));
			
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
