package com.laratecsys.inpaktaService;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.DbProperties;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;
import com.laratecsys.inpaktaService.Repositorie.DbPropertiesRepositories;

@SpringBootApplication
public class InpaktaServiceApplication{

	@Autowired
	private ClienteRepositories clienteRepositories;
	
	@Autowired
	private DbPropertiesRepositories dbPropertiesRepositories;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	public static void main(String[] args) {
		SpringApplication.run(InpaktaServiceApplication.class, args);
	}


}
