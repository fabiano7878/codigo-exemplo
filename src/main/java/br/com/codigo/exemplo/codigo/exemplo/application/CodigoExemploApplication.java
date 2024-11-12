package br.com.codigo.exemplo.codigo.exemplo.application;

import br.com.codigo.exemplo.codigo.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodigoExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodigoExemploApplication.class, args);
		PessoaService pessoaService = new PessoaService(new ObjectMapper());
		pessoaService.processaJson();
	}

}
