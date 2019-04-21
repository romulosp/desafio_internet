package com.br.romulo.desafio_internet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.romulo.desafio_internet.domain.CiaAerea;
@Repository
public interface CiaAereaRepository extends JpaRepository<CiaAerea, Long>{

}
