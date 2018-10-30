package com.gympass.domain;

public class Piloto {

	private int codigo;

	private String nome;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		try {
			this.codigo = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter codigo do piloto " + codigo);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Piloto() {
		super();
	}

	@Override
	public String toString() {
		return "Piloto [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
