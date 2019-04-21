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
import com.br.romulo.desafio_internet.domain.Executiva;
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
import com.br.romulo.desafio_internet.repositories.EnderecoRepository;
import com.br.romulo.desafio_internet.repositories.ExecutivaRepository;
import com.br.romulo.desafio_internet.repositories.HorarioRepository;
import com.br.romulo.desafio_internet.repositories.PessoaRepository;
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
	
	public void geraMassaTesteExecutiva() {
		
		CiaAerea tam = new CiaAerea(null, "TAM");
		
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
		
		rotaVooExecutiva.setCiaAerea(tam);
		
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
		
		Aviao aviaoExecutiva = new Aviao(null, "Avião Executiva", 20000.00, null, null, 20);
		
		horarioVooExecutiva.setAviao(aviaoExecutiva);
		aviaoRepository.save(aviaoExecutiva);
		
		horarioVooExecutiva.setAviao(aviaoExecutiva);
		
		tam.setAvioes(Arrays.asList(aviaoExecutiva));
		ciaAereaRepository.save(tam);
		
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
		
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(Calendar.YEAR, 1994);
		dataNascimento.set(Calendar.MONTH, 10);
		dataNascimento.set(Calendar.DAY_OF_MONTH, 10);
		
		Pessoa passageiro1 = new Passageiro(null, "Ingryd", "ingryd@gmail.com", "(61) 23211-2121", "Ingryd", "123", dataNascimento, "01202101232", "12312312223232");
		
		Endereco endereco  = new Endereco(null, "QNO", "19", "colegio 53", "ceilandia norte", "ceilândia", "DF", "Brasil");
		enderecoRepository.save(endereco);
		passageiro1.setEndereco(endereco);
		
		
		pessoaRepository.saveAll(Arrays.asList(passageiro1));
		executiva.setPassageiro((Passageiro) passageiro1);
		
		bilheteRepository.save(executiva);
		
	}
}
