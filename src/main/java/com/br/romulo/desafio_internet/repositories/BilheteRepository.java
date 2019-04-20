package com.br.romulo.desafio_internet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.romulo.desafio_internet.domain.Bilhete;

public interface BilheteRepository extends JpaRepository<Bilhete, Long>{

}
