package com.br.romulo.desafio_internet;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.romulo.desafio_internet.domain.Economica;
import com.br.romulo.desafio_internet.domain.Executiva;
import com.br.romulo.desafio_internet.domain.Primeira;
import com.br.romulo.desafio_internet.repositories.BilheteRepository;

@SpringBootApplication
public class DesafioInternetApplication implements CommandLineRunner {

	@Autowired
	private BilheteRepository bilheteRepository;

	@Autowired
	private GeraMassaTesteEconomica geraMassaTesteEconomica;

	@Autowired
	private GeraMassaTestePrimeira geraMassaTestePrimeira;

	@Autowired
	private GeraMassaTesteExecutiva geraMassaTesteExecutiva;

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
		Economica economica = geraMassaTesteEconomica.geraMassaTesteEconomica();
		Primeira primeira =  geraMassaTestePrimeira.geraMassaTestePrimeira();
		Executiva executiva = geraMassaTesteExecutiva.geraMassaTesteExecutiva();
		bilheteRepository.saveAll(Arrays.asList(economica,primeira,executiva));

	}

}
