package com.br.romulo.desafio_internet;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.romulo.desafio_internet.domain.Aeroporto;
import com.br.romulo.desafio_internet.domain.Aviao;
import com.br.romulo.desafio_internet.domain.Bagagem;
import com.br.romulo.desafio_internet.domain.CiaAerea;
import com.br.romulo.desafio_internet.domain.Economica;
import com.br.romulo.desafio_internet.domain.Endereco;
import com.br.romulo.desafio_internet.domain.Horario;
import com.br.romulo.desafio_internet.domain.Passageiro;
import com.br.romulo.desafio_internet.domain.Pessoa;
import com.br.romulo.desafio_internet.domain.Rota;
import com.br.romulo.desafio_internet.domain.SituacaoBilheteEnum;
import com.br.romulo.desafio_internet.domain.TipoBagagemEnum;
import com.br.romulo.desafio_internet.repositories.AeroportoRepository;
import com.br.romulo.desafio_internet.repositories.AviaoRepository;
import com.br.romulo.desafio_internet.repositories.BagagemRepository;
import com.br.romulo.desafio_internet.repositories.BilheteRepository;
import com.br.romulo.desafio_internet.repositories.CiaAereaRepository;
import com.br.romulo.desafio_internet.repositories.EconomicaRepository;
import com.br.romulo.desafio_internet.repositories.EnderecoRepository;
import com.br.romulo.desafio_internet.repositories.HorarioRepository;
import com.br.romulo.desafio_internet.repositories.PessoaRepository;
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
	
	@Autowired
	private CiaAereaRepository ciaAereaRepository;
	
	@Autowired
	private BilheteRepository bilheteRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void geraMassaTesteEconomica() {
		
		
		CiaAerea gol = new CiaAerea(null, "GOL");
		
		
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
		
		rotaVooEconomica.setCiaAerea(gol);
		
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
		aviaoEconomico.setCiaAerea(gol);
		
		horarioVooEconomica.setAviao(aviaoEconomico);
		
		gol.setAvioes(Arrays.asList(aviaoEconomico));
		ciaAereaRepository.save(gol);
		
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
		
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(Calendar.YEAR, 1991);
		dataNascimento.set(Calendar.MONTH, 11);
		dataNascimento.set(Calendar.DAY_OF_MONTH, 30);
		
		Pessoa passageiro1 = new Passageiro(null, "Romulo", "romulo@gmail.com", "(61) 3321-2121", "ROMULO", "123", dataNascimento, "11121212111", "12312120398109283");
		
		Endereco endereco  = new Endereco(null, "QNO", "7", "rua posto", "ceilandia norte", "ceilândia", "DF", "Brasil");
		enderecoRepository.save(endereco);
		passageiro1.setEndereco(endereco);
		
		pessoaRepository.saveAll(Arrays.asList(passageiro1));
		economica.setPassageiro((Passageiro) passageiro1);
		
		bilheteRepository.save(economica);
		
	}
}
