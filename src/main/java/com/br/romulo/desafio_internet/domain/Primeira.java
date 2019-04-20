package com.br.romulo.desafio_internet.domain;

import javax.persistence.Entity;

@Entity
public class Primeira extends Bilhete{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  Primeira() {}

	public Primeira(Long id, Integer numero, String assento, SituacaoBilheteEnum situacaoBilhete,
			 Horario horario) {
		super(id, numero, assento, situacaoBilhete, TipoBilheteEnum.PRIMEIRA, horario);
	}

}
