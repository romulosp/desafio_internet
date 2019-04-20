package com.br.romulo.desafio_internet.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Bagagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double peso;
	
	public Bagagem() {
	}
	
	public Bagagem(Long id, Double peso) {
		super();
		this.id = id;
		this.peso = peso;
	}



	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
				name="BILHETE_BAGAGEM",
				joinColumns= @JoinColumn(name="id_bagagem"),
				inverseJoinColumns = @JoinColumn(name="id_bilhete")
			)
	private List<Bilhete> bilhetes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
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
		Bagagem other = (Bagagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Bilhete> getBilhetes() {
		return bilhetes;
	}

	public void setBilhetes(List<Bilhete> bilhetes) {
		this.bilhetes = bilhetes;
	}
}
