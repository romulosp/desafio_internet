package com.br.romulo.desafio_internet;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.br.romulo.desafio_internet.domain.CiaAerea;
import com.br.romulo.desafio_internet.domain.Funcionario;
import com.br.romulo.desafio_internet.domain.Papel;
import com.br.romulo.desafio_internet.repositories.CiaAereaRepository;
import com.br.romulo.desafio_internet.repositories.FuncionarioRepository;
import com.br.romulo.desafio_internet.repositories.PapelRepository;

@Service
public class GeraMassaTesteFuncionario implements CommandLineRunner{

	@Autowired
	private PapelRepository papelRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private CiaAereaRepository ciaAereaRepository;
	
	public void geraMassaTesteFuncionario() {
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		CiaAerea ciaAerea1 = ciaAereaRepository.findById(1l).get();
		CiaAerea ciaAerea2 = ciaAereaRepository.findById(2l).get();
		Papel piloto = new  Papel(null, "PILOTO", "PILOTO ");
		piloto.setCiaAerea(Arrays.asList(ciaAerea1,ciaAerea2));
		papelRepository.save(piloto);
		
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(Calendar.YEAR, 1984);
		dataNascimento.set(Calendar.MONTH, 8);
		dataNascimento.set(Calendar.DAY_OF_MONTH, 2);
		Funcionario funcionario = new Funcionario(null, "werton", "weton@gas.com", "6177118181", "werton", "423", dataNascimento, "s2jasj#a", "123123221222");
		funcionario.setPapel(piloto);
		funcionarioRepository.save(funcionario);
	}
}
