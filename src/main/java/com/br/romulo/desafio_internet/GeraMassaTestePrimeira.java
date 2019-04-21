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
import com.br.romulo.desafio_internet.domain.Endereco;
import com.br.romulo.desafio_internet.domain.Horario;
import com.br.romulo.desafio_internet.domain.Passageiro;
import com.br.romulo.desafio_internet.domain.Pessoa;
import com.br.romulo.desafio_internet.domain.Primeira;
import com.br.romulo.desafio_internet.domain.Rota;
import com.br.romulo.desafio_internet.domain.SituacaoBilheteEnum;
import com.br.romulo.desafio_internet.domain.TipoBagagemEnum;
import com.br.romulo.desafio_internet.repositories.AeroportoRepository;
import com.br.romulo.desafio_internet.repositories.AviaoRepository;
import com.br.romulo.desafio_internet.repositories.BagagemRepository;
import com.br.romulo.desafio_internet.repositories.BilheteRepository;
import com.br.romulo.desafio_internet.repositories.CiaAereaRepository;
import com.br.romulo.desafio_internet.repositories.EnderecoRepository;
import com.br.romulo.desafio_internet.repositories.HorarioRepository;
import com.br.romulo.desafio_internet.repositories.PessoaRepository;
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
	
	public void geraMassaTestePrimeira() {
		
		CiaAerea latam = new CiaAerea(null, "Latam");
		
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
		
		rotaVooPrimeira.setCiaAerea(latam);
		
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
		
		Aviao aviaoPrimeira = new Aviao(null, "Avião Primeira", 50000.00, null, 60, null);
		
		horarioVooPrimeira.setAviao(aviaoPrimeira);
		aviaoRepository.save(aviaoPrimeira);
		
		horarioVooPrimeira.setAviao(aviaoPrimeira);
		
		latam.setAvioes(Arrays.asList(aviaoPrimeira));
		ciaAereaRepository.save(latam);
		
		
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
		
		
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(Calendar.YEAR, 1954);
		dataNascimento.set(Calendar.MONTH, 5);
		dataNascimento.set(Calendar.DAY_OF_MONTH, 10);
		
		Pessoa passageiro1 = new Passageiro(null, "Gildete", "gildete@gmail.com", "(61) 2231-3212", "Gildete", "3213", dataNascimento, "02040120301", "321312324323232");
		
		Endereco endereco  = new Endereco(null, "QNO", "20", "colegio 62", "ceilandia norte", "ceilândia", "DF", "Brasil");
		enderecoRepository.save(endereco);
		passageiro1.setEndereco(endereco);
		
		
		pessoaRepository.saveAll(Arrays.asList(passageiro1));
		primeira.setPassageiro((Passageiro) passageiro1);
		
		bilheteRepository.save(primeira);
	}
}
