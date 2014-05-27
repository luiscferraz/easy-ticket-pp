package br.ufrpe.easyticket.aluno.dominio;

import java.sql.Date;

import negocio.Pessoa;

public class Aluno extends Pessoa{
	
	private int idCurso;

	public Aluno(int id, String nome, String email, String cpf,
			String telefone, Date dataNascimento, String status,int idCurso) {
		super(id, nome, email, cpf, telefone, dataNascimento, status);
		this.idCurso=idCurso;		
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	
	
	
    
	
        
	
	
	

	
	
	
	
    
    

}
