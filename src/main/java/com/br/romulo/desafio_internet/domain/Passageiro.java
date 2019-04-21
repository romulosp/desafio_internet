package com.br.romulo.desafio_internet.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Passageiro extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String documento;
	private String numeroCartao;
	
	public Passageiro() {}
	
	@OneToMany
	private List<Bilhete> bilhete;

	public Passageiro(Long id, String nome, String email, String telefone, String usuario, String senha,
			Calendar dataNascimento,String documento,String numeroCartao) {
		super(id, nome, email, telefone, usuario, senha, dataNascimento);
		this.documento = documento;
		this.numeroCartao = numeroCartao;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public List<Bilhete> getBilhete() {
		return bilhete;
	}

	public void setBilhete(List<Bilhete> bilhete) {
		this.bilhete = bilhete;
	}
	
}
