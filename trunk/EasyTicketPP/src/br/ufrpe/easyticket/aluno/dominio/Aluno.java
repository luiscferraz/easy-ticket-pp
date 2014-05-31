package br.ufrpe.easyticket.aluno.dominio;

import br.ufrpe.easyticket.curso.dominio.Curso;
import br.ufrpe.easyticket.pessoa.dominio.Pessoa;


public class Aluno {
	
	private Pessoa pessoa;
	private Curso curso;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Aluno [pessoa=" + pessoa + ", curso=" + curso + "]";
	}
	
	
	
	
	
	
	



	
	
	
    
	
        
	
	
	

	
	
	
	
    
    

}
