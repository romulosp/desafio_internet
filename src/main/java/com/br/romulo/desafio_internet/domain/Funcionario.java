package com.br.romulo.desafio_internet.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Funcionario extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String contaCorrente;
	@OneToOne
	private Papel papel;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Long id, String nome, String email, String telefone, String usuario, String senha,
			Calendar dataNascimento,String codigo,String contaCorrente) {
		super(id, nome, email, telefone, usuario, senha, dataNascimento);
		 this.codigo = codigo;
		 this.contaCorrente = contaCorrente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}
	
}
