package com.br.romulo.desafio_internet.domain;

import javax.persistence.Entity;

@Entity
public class Economica extends Bilhete{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Economica() {}

	public Economica(Long id, 
			Integer numero, 
			String assento,
			SituacaoBilheteEnum situacaoBilhete,
			Horario horario) {
		super(id, numero, assento, situacaoBilhete, TipoBilheteEnum.ECONOMICA, horario);
	}

}
