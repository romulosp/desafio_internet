package com.br.romulo.desafio_internet.domain;

public enum TipoBagagemEnum {

	
	MAO(5.0),
	NACIONAL(23.0),
	INTERNACIONAL(32.0)
	;
	
	private Double valor;

	private TipoBagagemEnum(Double valor) {
		this.valor = valor;
	}

	 public Double getValor() {
		return valor;
	}
	
	public static TipoBagagemEnum getTipoBagagem(Double valor) {
		TipoBagagemEnum retorno = null;
		if(valor != null) {
			for(TipoBagagemEnum situacaoBoleto : TipoBagagemEnum.values()) {
				if(situacaoBoleto.getValor().equals(valor)) {
					retorno = situacaoBoleto;
				}
			}
		}
		return retorno;
	}
}
