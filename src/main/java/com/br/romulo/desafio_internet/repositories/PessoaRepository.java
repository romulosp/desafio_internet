package com.br.romulo.desafio_internet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.romulo.desafio_internet.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
