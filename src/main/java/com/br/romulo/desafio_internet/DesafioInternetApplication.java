package com.br.romulo.desafio_internet;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.romulo.desafio_internet.domain.Bagagem;
import com.br.romulo.desafio_internet.domain.Economica;
import com.br.romulo.desafio_internet.domain.Executiva;
import com.br.romulo.desafio_internet.domain.Horario;
import com.br.romulo.desafio_internet.domain.Primeira;
import com.br.romulo.desafio_internet.domain.Rota;
import com.br.romulo.desafio_internet.domain.SituacaoBilheteEnum;
import com.br.romulo.desafio_internet.domain.TipoBagagemEnum;
import com.br.romulo.desafio_internet.repositories.BagagemRepository;
import com.br.romulo.desafio_internet.repositories.BilheteRepository;
import com.br.romulo.desafio_internet.repositories.EconomicaRepository;
import com.br.romulo.desafio_internet.repositories.ExecutivaRepository;
import com.br.romulo.desafio_internet.repositories.HorarioRepository;
import com.br.romulo.desafio_internet.repositories.PrimeiraRepository;
import com.br.romulo.desafio_internet.repositories.RotaRepository;

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
	
	@Autowired
	private BagagemRepository bagagemRepository;
	
	@Autowired
	private RotaRepository rotaRepository;
	
	
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
		
		
		Bagagem bagemEconomica1=  new  Bagagem(null, 8.00) ;
		bagemEconomica1.setTipoBagagem(TipoBagagemEnum.INTERNACIONAL);
		
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
		
		Rota rotaVooEconomica = new Rota(null, "ROTA ECONOMICA", "DESCRICAO ROTA ECONOMICA");
		rotaRepository.save(rotaVooEconomica);
		horarioVooEconomica.setRota(rotaVooEconomica);
		
		horarioRepository.save(horarioVooEconomica);
		
		Economica economica =  new Economica(
				null,
				8281, 
				"4c", 
				SituacaoBilheteEnum.DISPONIVEL, 
				horarioVooEconomica
				);
		bagemEconomica1.setBilhetes(Arrays.asList(economica));
		bagagemRepository.save(bagemEconomica1);
		economicaRepository.save(economica);
		
		economica.setBagagens(Arrays.asList(bagemEconomica1));
				
		
		Calendar horarioPartidaPrimeira = Calendar.getInstance();
		horarioPartidaPrimeira.set(Calendar.DAY_OF_YEAR, 2);
		horarioPartidaPrimeira.set(Calendar.MONTH, 6);
		horarioPartidaPrimeira.set(Calendar.YEAR, 2019);
		
		Calendar horarioChegadaPrimeira = Calendar.getInstance();
		horarioPartidaPrimeira.set(Calendar.DAY_OF_YEAR, 2);
		horarioPartidaPrimeira.set(Calendar.MONTH, 6);
		horarioPartidaPrimeira.set(Calendar.YEAR, 2019);
		
		
		Bagagem bagemPrimeira1=  new  Bagagem(null, 3.00) ;
		bagemPrimeira1.setTipoBagagem(TipoBagagemEnum.MAO);
		Bagagem bagemPrimeira2=  new  Bagagem(null, 4.00) ;
		bagemPrimeira2.setTipoBagagem(TipoBagagemEnum.MAO);
		
		
		
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
		
		Rota rotaVooPrimeira = new Rota(null, "ROTA Primeira", "DESCRICAO ROTA Primeira");
		rotaRepository.save(rotaVooPrimeira);
		horarioVooPrimeira.setRota(rotaVooPrimeira);
		
		horarioRepository.save(horarioVooPrimeira);
		
		Primeira primeira = new Primeira(
				null,
				6967, 
				"2c",
				SituacaoBilheteEnum.VENDIDO,
				horarioVooPrimeira
			);
		
		
		primeira.setBagagens(Arrays.asList(bagemPrimeira1,bagemPrimeira2));
		bagemPrimeira1.setBilhetes(Arrays.asList(primeira));
		bagagemRepository.saveAll(Arrays.asList(bagemPrimeira1,bagemPrimeira2));
		primeiraRepository.save(primeira);
		
		Calendar horarioPartidaExecutiva = Calendar.getInstance();
		horarioPartidaExecutiva.set(Calendar.DAY_OF_YEAR, 15);
		horarioPartidaExecutiva.set(Calendar.MONTH, 8);
		horarioPartidaExecutiva.set(Calendar.YEAR, 2019);
		
		Calendar horarioChegadaExecutiva = Calendar.getInstance();
		horarioChegadaExecutiva.set(Calendar.DAY_OF_YEAR, 15);
		horarioChegadaExecutiva.set(Calendar.MONTH, 8);
		horarioChegadaExecutiva.set(Calendar.YEAR, 2019);
		
		Bagagem bagemExecutiva1=  new  Bagagem(null, 7.00) ;
		bagemExecutiva1.setTipoBagagem(TipoBagagemEnum.NACIONAL);
		Bagagem bagemExecutiva2=  new  Bagagem(null, 6.00) ;
		bagemExecutiva2.setTipoBagagem(TipoBagagemEnum.NACIONAL);
		Bagagem bagemExecutiva3=  new  Bagagem(null, 9.00) ;
		bagemExecutiva3.setTipoBagagem(TipoBagagemEnum.NACIONAL);
		
		
		
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
		
		Rota rotaVooExecutiva = new Rota(null, "ROTA Executiva", "DESCRICAO ROTA Executiva");
		rotaRepository.save(rotaVooExecutiva);
		horarioVooExecutiva.setRota(rotaVooExecutiva);
		
		horarioRepository.save(horarioVooExecutiva);
		
		Executiva executiva = new Executiva(
				null,
				2111,
				"AC",
				SituacaoBilheteEnum.RESERVADO,
				horarioVooExecutiva);
		
		executiva.setBagagens(Arrays.asList(bagemExecutiva1,bagemExecutiva2,bagemExecutiva3));
		
		bagemExecutiva3.setBilhetes(Arrays.asList(executiva));
		bagagemRepository.saveAll(Arrays.asList(bagemExecutiva1,bagemExecutiva2,bagemExecutiva3));
		executivaRepository.save(executiva);
		
	 
		
		bilheteRepository.saveAll(Arrays.asList(economica,primeira,executiva));
		
	}

}
