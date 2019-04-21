package com.br.romulo.desafio_internet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.romulo.desafio_internet.domain.Rota;
@Repository
public interface RotaRepository extends JpaRepository<Rota, Long>{

}
