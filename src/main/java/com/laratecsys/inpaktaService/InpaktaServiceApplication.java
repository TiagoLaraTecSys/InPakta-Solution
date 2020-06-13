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
public class InpaktaServiceApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepositories clienteRepositories;
	
	@Autowired
	private DbPropertiesRepositories dbPropertiesRepositories;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	public static void main(String[] args) {
		SpringApplication.run(InpaktaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente teste = new Cliente(null, "Tiago", "de Lara Ribeiro", "tiagolararibeiro1998@gmail.com",pe.encode("1234"));
		
		DbProperties newDbProperties = new DbProperties(null,"", "mysql", "com.mysql.jdbc.Driver", "inpakt79_root", "1s1@f23ty",
				"inpakt79_inpaktdb", "jdbc:mysql://inpakta.com.br/inpakt79_inpaktdb",1,teste);
		
		teste.getDbProperties().addAll(Arrays.asList(newDbProperties));
				
		clienteRepositories.saveAll(Arrays.asList(teste));
		
		dbPropertiesRepositories.saveAll(Arrays.asList(newDbProperties));
		
		//DataResult dataResult = new DataResult(null, run_id, run_timestamp, schema_name, table_name, column_name, probability, model, model_mode, dictionary, num_rows, score, sample_data, dbProperties)
		
		
	}

}
