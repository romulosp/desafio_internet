package com.br.romulo.desafio_internet.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Horario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	@Temporal(TemporalType.DATE)
	private Calendar partidade;
	@Temporal(TemporalType.DATE)
	private Calendar chegada;
	private Integer qtdEconomica;
	private Integer qtdPrimeira;
	private Integer qtdExecutiva;
	 
	public Horario() {}
	
	
	
	public Horario(Long id, String codigo, Calendar partidade, Calendar chegada, Integer qtdEconomica,
			Integer qtdPrimeira, Integer qtdExecutiva) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.partidade = partidade;
		this.chegada = chegada;
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
	public Calendar getPartidade() {
		return partidade;
	}
	public void setPartidade(Calendar partidade) {
		this.partidade = partidade;
	}
	public Calendar getChegada() {
		return chegada;
	}
	public void setChegada(Calendar chegada) {
		this.chegada = chegada;
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
		Horario other = (Horario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
