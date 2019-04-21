package com.br.romulo.desafio_internet;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.romulo.desafio_internet.domain.Aeroporto;
import com.br.romulo.desafio_internet.domain.Bagagem;
import com.br.romulo.desafio_internet.domain.Executiva;
import com.br.romulo.desafio_internet.domain.Horario;
import com.br.romulo.desafio_internet.domain.Rota;
import com.br.romulo.desafio_internet.domain.SituacaoBilheteEnum;
import com.br.romulo.desafio_internet.domain.TipoBagagemEnum;
import com.br.romulo.desafio_internet.repositories.AeroportoRepository;
import com.br.romulo.desafio_internet.repositories.BagagemRepository;
import com.br.romulo.desafio_internet.repositories.ExecutivaRepository;
import com.br.romulo.desafio_internet.repositories.HorarioRepository;
import com.br.romulo.desafio_internet.repositories.RotaRepository;

@Service
public class GeraMassaTesteExecutiva {
	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private BagagemRepository bagagemRepository;
	
	@Autowired
	private ExecutivaRepository executivaRepository;
	 
	public Executiva geraMassaTesteExecutiva() {
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
		
		Aeroporto aeroportoExecutiva1 = new Aeroporto(null, "aeroporto 1 Executiva ", "A1s");
		Aeroporto aeroportoExecutiva2 = new Aeroporto(null, "aeroporto 2 Executiva", "ASQ");
		Aeroporto aeroportoExecutiva3 = new Aeroporto(null, "aeroporto 3 Executiva", "DSW");
		aeroportoExecutiva1.setRotas(Arrays.asList(rotaVooExecutiva));
		aeroportoExecutiva2.setRotas(Arrays.asList(rotaVooExecutiva));
		aeroportoExecutiva3.setRotas(Arrays.asList(rotaVooExecutiva));
		
		List<Aeroporto> listAeroportosExecutiva = Arrays.asList(aeroportoExecutiva1,aeroportoExecutiva2,aeroportoExecutiva3);
		
		rotaVooExecutiva.setAeroportos(listAeroportosExecutiva);
		aeroportoRepository.saveAll(listAeroportosExecutiva);
		
		
		rotaVooExecutiva.setAeroportos(Arrays.asList(aeroportoExecutiva1,aeroportoExecutiva2,aeroportoExecutiva3));
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
		return executiva;
	}
}
