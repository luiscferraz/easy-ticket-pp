package br.ufrpe.easyticket.curso.dominio;

import br.ufrpe.easyticket.infra.negocio.MyObject;

public class Curso extends MyObject{

	
	private String nome;
	
	
	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + "]";
	}
	
	
	
	
	
	
}
