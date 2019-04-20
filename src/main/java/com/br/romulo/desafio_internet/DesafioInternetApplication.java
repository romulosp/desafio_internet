package com.br.romulo.desafio_internet;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.romulo.desafio_internet.domain.Economica;
import com.br.romulo.desafio_internet.domain.Executiva;
import com.br.romulo.desafio_internet.domain.Horario;
import com.br.romulo.desafio_internet.domain.Primeira;
import com.br.romulo.desafio_internet.domain.SituacaoBilheteEnum;
import com.br.romulo.desafio_internet.repositories.BilheteRepository;
import com.br.romulo.desafio_internet.repositories.EconomicaRepository;
import com.br.romulo.desafio_internet.repositories.ExecutivaRepository;
import com.br.romulo.desafio_internet.repositories.HorarioRepository;
import com.br.romulo.desafio_internet.repositories.PrimeiraRepository;

@SpringBootApplication
public class DesafioInternetApplication implements CommandLineRunner {
	
	@Autowired
	private BilheteRepository bilheteRepository;
	
	@Autowired
	private EconomicaRepository economicaRepository;
	
	@Autowired
	private ExecutivaRepository executivaRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private PrimeiraRepository primeiraRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioInternetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Calendar horarioPartidaEconomica = Calendar.getInstance();
		horarioPartidaEconomica.set(Calendar.DAY_OF_YEAR, 20);
		horarioPartidaEconomica.set(Calendar.MONTH, 4);
		horarioPartidaEconomica.set(Calendar.YEAR, 2019);
		
		Calendar horarioChegadaEconomica = Calendar.getInstance();
		horarioPartidaEconomica.set(Calendar.DAY_OF_YEAR, 21);
		horarioPartidaEconomica.set(Calendar.MONTH, 4);
		horarioPartidaEconomica.set(Calendar.YEAR, 2019);
		
		Horario horarioVooEconomica =
				new Horario(
						null, 
						"#SAS",
						horarioPartidaEconomica, 
						horarioChegadaEconomica, 
						1,
						null, 
						null
				);
		
		horarioRepository.save(horarioVooEconomica);
		
		Economica economica =  new Economica(
				null,
				8281, 
				"4c", 
				SituacaoBilheteEnum.DISPONIVEL, 
				horarioVooEconomica
				);
		
		economicaRepository.save(economica);
				
		
		Calendar horarioPartidaPrimeira = Calendar.getInstance();
		horarioPartidaPrimeira.set(Calendar.DAY_OF_YEAR, 2);
		horarioPartidaPrimeira.set(Calendar.MONTH, 6);
		horarioPartidaPrimeira.set(Calendar.YEAR, 2019);
		
		Calendar horarioChegadaPrimeira = Calendar.getInstance();
		horarioPartidaPrimeira.set(Calendar.DAY_OF_YEAR, 2);
		horarioPartidaPrimeira.set(Calendar.MONTH, 6);
		horarioPartidaPrimeira.set(Calendar.YEAR, 2019);
		
		Horario horarioVooPrimeira =
				new Horario(
						null, 
						"#CSD",
						horarioPartidaPrimeira, 
						horarioChegadaPrimeira, 
						null,
						2, 
						null
				);
		horarioRepository.save(horarioVooPrimeira);
		
		Primeira primeira = new Primeira(
				null,
				6967, 
				"2c",
				SituacaoBilheteEnum.VENDIDO,
				horarioVooPrimeira
			);
		
		primeiraRepository.save(primeira);
		
		Calendar horarioPartidaExecutiva = Calendar.getInstance();
		horarioPartidaExecutiva.set(Calendar.DAY_OF_YEAR, 15);
		horarioPartidaExecutiva.set(Calendar.MONTH, 8);
		horarioPartidaExecutiva.set(Calendar.YEAR, 2019);
		
		Calendar horarioChegadaExecutiva = Calendar.getInstance();
		horarioChegadaExecutiva.set(Calendar.DAY_OF_YEAR, 15);
		horarioChegadaExecutiva.set(Calendar.MONTH, 8);
		horarioChegadaExecutiva.set(Calendar.YEAR, 2019);
		
		Horario horarioVooExecutiva = 
				new Horario(
						null, 
						"#weS",
						horarioPartidaExecutiva, 
						horarioChegadaExecutiva, 
						null,
						null, 
						3
				);
		
		horarioRepository.save(horarioVooExecutiva);
		
		Executiva executiva = new Executiva(
				null,
				2111,
				"AC",
				SituacaoBilheteEnum.RESERVADO,
				horarioVooExecutiva);
		
		executivaRepository.save(executiva);
		
		bilheteRepository.saveAll(Arrays.asList(economica,primeira,executiva));
		
	}

}
