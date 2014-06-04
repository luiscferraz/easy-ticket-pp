package br.ufrpe.easyticket.pessoa.dominio;

import java.sql.Date;

import br.ufrpe.easyticket.infra.negocio.MyObject;

public class Pessoa extends MyObject{
	
	public enum Status{
    	ATIVO,INATIVO
    }
		
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private java.sql.Date dataNascimento;    
    private Status status;
    
	
	public Pessoa(String nome, String email, String cpf, String telefone,
			Date dataNascimento, Status status) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.status = status;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public java.sql.Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", email=" + email + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", dataNascimento="
				+ dataNascimento + ", status=" + status + "]";
	}

	
	
	
    
    
    
	
	
	
    
    
    
    
}
