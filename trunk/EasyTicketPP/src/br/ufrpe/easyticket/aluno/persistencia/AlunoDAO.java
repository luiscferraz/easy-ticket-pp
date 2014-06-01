package br.ufrpe.easyticket.aluno.persistencia;

import br.ufrpe.easyticket.aluno.dominio.Aluno;
import br.ufrpe.easyticket.infra.persistencia.GenericDAO;
import br.ufrpe.easyticket.pessoa.dominio.Pessoa;

public class AlunoDAO extends GenericDAO {

	public void save(Aluno aluno) throws Exception{
		String query = "INSERT INTO ALUNOS (id,nome) VALUES (?,?)";
		
		int nextId = this.getNextId("alunos");
		
		Pessoa pessoa = aluno.getPessoa();
		pessoa.setId(nextId);
		
		this.executeQuery(query, aluno.getPessoa().getId(),aluno.getPessoa().getNome());
		
	}
	
	
}
