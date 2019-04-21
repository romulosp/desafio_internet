package com.br.romulo.desafio_internet.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Aviao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	private Double carga;
	
	private Integer qtdEconomica;
	private Integer qtdPrimeira;
	private Integer qtdExecutiva;
	
	@OneToOne
	private Endereco endereco;
	
	@OneToOne
	private CiaAerea ciaAerea;
	
	public Aviao() {}
	
	
	
	public Aviao(Long id, String codigo, Double carga, Integer qtdEconomica, Integer qtdPrimeira, Integer qtdExecutiva ) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.carga = carga;
		this.qtdEconomica = qtdEconomica;
		this.qtdPrimeira = qtdPrimeira;
		this.qtdExecutiva = qtdExecutiva;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getCarga() {
		return carga;
	}
	public void setCarga(Double carga) {
		this.carga = carga;
	}
	public Integer getQtdEconomica() {
		return qtdEconomica;
	}
	public void setQtdEconomica(Integer qtdEconomica) {
		this.qtdEconomica = qtdEconomica;
	}
	public Integer getQtdPrimeira() {
		return qtdPrimeira;
	}
	public void setQtdPrimeira(Integer qtdPrimeira) {
		this.qtdPrimeira = qtdPrimeira;
	}
	public Integer getQtdExecutiva() {
		return qtdExecutiva;
	}
	public void setQtdExecutiva(Integer qtdExecutiva) {
		this.qtdExecutiva = qtdExecutiva;
	}
	
	public CiaAerea getCiaAerea() {
		return ciaAerea;
	}

	public void setCiaAerea(CiaAerea ciaAerea) {
		this.ciaAerea = ciaAerea;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aviao other = (Aviao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
