package com.br.romulo.desafio_internet.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Bilhete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer numero;

	private String assento;

	@JoinColumn(name = "SITUACAO_BOLETO")
	private Integer situacaoBilhete;

	@JoinColumn(name = "TIPO_BILHETE")
	private Integer tipoBilhete;

	@OneToOne
	private Horario horario;

	public Bilhete() {
	}

	public Bilhete(Long id, Integer numero, String assento, SituacaoBilheteEnum situacaoBilhete,
			TipoBilheteEnum tipoBilhete, Horario horario) {
		super();
		this.id = id;
		this.numero = numero;
		this.assento = assento;
		this.situacaoBilhete = situacaoBilhete.getCodigo();
		this.tipoBilhete = tipoBilhete.getCodigo();
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getAssento() {
		return assento;
	}

	public void setAssento(String assento) {
		this.assento = assento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public SituacaoBilheteEnum getSituacaoBilhete() {
		return SituacaoBilheteEnum.getSituacao(situacaoBilhete);
	}

	public void setSituacaoBilhete(SituacaoBilheteEnum situacaoBilhete) {
		this.situacaoBilhete = situacaoBilhete.getCodigo();
	}

	public TipoBilheteEnum getTipoBilhete() {
		return TipoBilheteEnum.getTipoBilhete(tipoBilhete);
	}

	public void setTipoBilhete(TipoBilheteEnum tipoBilhete) {
		this.tipoBilhete = tipoBilhete.getCodigo();
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bilhete other = (Bilhete) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}