package com.br.romulo.desafio_internet.domain;

public enum TipoBilheteEnum {

	
	ECONOMICA(1),
	EXECUTIVA(2),
	PRIMEIRA(3)
	
	;
	
	private Integer codigo;

	private TipoBilheteEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public static TipoBilheteEnum getTipoBilhete(Integer codigo) {
		TipoBilheteEnum retorno = null;
		if(codigo != null) {
			for(TipoBilheteEnum situacaoBoleto : TipoBilheteEnum.values()) {
				if(situacaoBoleto.getCodigo().equals(codigo)) {
					retorno = situacaoBoleto;
				}
			}
		}
		return retorno;
	}
}
