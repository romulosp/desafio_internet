package com.br.romulo.desafio_internet;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.romulo.desafio_internet.domain.Aeroporto;
import com.br.romulo.desafio_internet.domain.Aviao;
import com.br.romulo.desafio_internet.domain.Bagagem;
import com.br.romulo.desafio_internet.domain.Economica;
import com.br.romulo.desafio_internet.domain.Horario;
import com.br.romulo.desafio_internet.domain.Rota;
import com.br.romulo.desafio_internet.domain.SituacaoBilheteEnum;
import com.br.romulo.desafio_internet.domain.TipoBagagemEnum;
import com.br.romulo.desafio_internet.repositories.AeroportoRepository;
import com.br.romulo.desafio_internet.repositories.AviaoRepository;
import com.br.romulo.desafio_internet.repositories.BagagemRepository;
import com.br.romulo.desafio_internet.repositories.EconomicaRepository;
import com.br.romulo.desafio_internet.repositories.HorarioRepository;
import com.br.romulo.desafio_internet.repositories.RotaRepository;


@Service
public class GeraMassaTesteEconomica {

	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private BagagemRepository bagagemRepository;
	
	@Autowired
	private EconomicaRepository economicaRepository;
	
	@Autowired
	private AviaoRepository aviaoRepository;
	
	
	public Economica geraMassaTesteEconomica() {
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
		Aeroporto aeroportoEconomica1 = new Aeroporto(null, "aeroporto 1 Economica ", "A1s");
		Aeroporto aeroportoEconomica2 = new Aeroporto(null, "aeroporto 2 Economica", "ASQ");
		Aeroporto aeroportoEconomica3 = new Aeroporto(null, "aeroporto 3 Economica", "DSW");
		Aeroporto aeroportoEconomica4 = new Aeroporto(null, "aeroporto 4 Economica", "GDS");
		
		
		aeroportoEconomica1.setRotas(Arrays.asList(rotaVooEconomica));
		aeroportoEconomica2.setRotas(Arrays.asList(rotaVooEconomica));
		aeroportoEconomica3.setRotas(Arrays.asList(rotaVooEconomica));
		aeroportoEconomica4.setRotas(Arrays.asList(rotaVooEconomica));
		
		List<Aeroporto> listAeroportosEconomica = Arrays.asList(aeroportoEconomica1,aeroportoEconomica2,aeroportoEconomica3,aeroportoEconomica4);
		
		rotaVooEconomica.setAeroportos(listAeroportosEconomica);
		
		aeroportoRepository.saveAll(listAeroportosEconomica);
		
		rotaRepository.save(rotaVooEconomica);
		horarioVooEconomica.setRota(rotaVooEconomica);
		
		Aviao aviaoEconomico = new Aviao(null, "Avião economico", 10000.00, 10, null, null);
		
		horarioVooEconomica.setAviao(aviaoEconomico);
		aviaoRepository.save(aviaoEconomico);
		
		horarioVooEconomica.setAviao(aviaoEconomico);
		
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
		return economica;
	}
}
