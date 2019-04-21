package com.br.romulo.desafio_internet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioInternetApplication implements CommandLineRunner {

	@Autowired
	private GeraMassaTesteEconomica geraMassaTesteEconomica;

	@Autowired
	private GeraMassaTestePrimeira geraMassaTestePrimeira;

	@Autowired
	private GeraMassaTesteExecutiva geraMassaTesteExecutiva;
	
	@Autowired GeraMassaTesteFuncionario geraMassaTesteFuncionario;

	public static void main(String[] args) {
		SpringApplication.run(DesafioInternetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * 
		 * Teste modelagem conceitual
		 * 
		 * Teste de conceito 
		 * 
		 */
		 geraMassaTesteEconomica.geraMassaTesteEconomica();
		 geraMassaTestePrimeira.geraMassaTestePrimeira();
		 geraMassaTesteExecutiva.geraMassaTesteExecutiva();
		 geraMassaTesteFuncionario.geraMassaTesteFuncionario();
	}

}
