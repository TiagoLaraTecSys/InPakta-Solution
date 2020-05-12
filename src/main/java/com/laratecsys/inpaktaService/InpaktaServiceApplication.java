package com.laratecsys.inpaktaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Repositorie.ClienteRepositories;

@SpringBootApplication
public class InpaktaServiceApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepositories clienteRepositories;
	
	public static void main(String[] args) {
		SpringApplication.run(InpaktaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente teste = new Cliente(null, "Tiago", "de Lara Ribeiro", "tiagolararibeiro1998@gmail.com");
		
		clienteRepositories.save(teste);
		
		
	}

}
