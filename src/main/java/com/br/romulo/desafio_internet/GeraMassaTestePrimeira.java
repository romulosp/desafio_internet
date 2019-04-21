package com.br.romulo.desafio_internet;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.romulo.desafio_internet.domain.Aeroporto;
import com.br.romulo.desafio_internet.domain.Bagagem;
import com.br.romulo.desafio_internet.domain.Horario;
import com.br.romulo.desafio_internet.domain.Primeira;
import com.br.romulo.desafio_internet.domain.Rota;
import com.br.romulo.desafio_internet.domain.SituacaoBilheteEnum;
import com.br.romulo.desafio_internet.domain.TipoBagagemEnum;
import com.br.romulo.desafio_internet.repositories.AeroportoRepository;
import com.br.romulo.desafio_internet.repositories.BagagemRepository;
import com.br.romulo.desafio_internet.repositories.HorarioRepository;
import com.br.romulo.desafio_internet.repositories.PrimeiraRepository;
import com.br.romulo.desafio_internet.repositories.RotaRepository;

@Service
public class GeraMassaTestePrimeira {
	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private BagagemRepository bagagemRepository;
	
	@Autowired
	private PrimeiraRepository primeiraRepository;
	
	public Primeira geraMassaTestePrimeira() {
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
		Aeroporto aeroportoPrimeira1 = new Aeroporto(null, "aeroporto 1 Primeira ", "A1s");
		Aeroporto aeroportoPrimeira2 = new Aeroporto(null, "aeroporto 2 Primeira", "ASQ");
		 
		
		aeroportoPrimeira1.setRotas(Arrays.asList(rotaVooPrimeira));
		aeroportoPrimeira2.setRotas(Arrays.asList(rotaVooPrimeira));
		List<Aeroporto> listAeroportosPrimeira = Arrays.asList(aeroportoPrimeira1,aeroportoPrimeira2);
		rotaVooPrimeira.setAeroportos(listAeroportosPrimeira);
		aeroportoRepository.saveAll(listAeroportosPrimeira);
		
		rotaVooPrimeira.setAeroportos(Arrays.asList(aeroportoPrimeira1,aeroportoPrimeira2));
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
		return primeira;
	}
}
