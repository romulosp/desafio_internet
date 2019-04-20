package com.br.romulo.desafio_internet.domain;

public enum SituacaoBilheteEnum {

	
	DISPONIVEL(1),
	RESERVADO(2),
	VENDIDO(3)
	
	;
	
	private Integer codigo;

	private SituacaoBilheteEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public static SituacaoBilheteEnum getSituacao(Integer codigo) {
		SituacaoBilheteEnum retorno = null;
		if(codigo != null) {
			for(SituacaoBilheteEnum situacaoBoleto : SituacaoBilheteEnum.values()) {
				if(situacaoBoleto.getCodigo().equals(codigo)) {
					retorno = situacaoBoleto;
				}
			}
		}
		return retorno;
	}
}
