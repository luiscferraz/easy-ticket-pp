package br.ufrpe.easyticket.aluno.persistencia;

import br.ufrpe.easyticket.aluno.dominio.Aluno;
import br.ufrpe.easyticket.infra.persistencia.GenericDAO;
import br.ufrpe.easyticket.pessoa.dominio.Pessoa;

public class AlunoDAO extends GenericDAO {

	@Override
	protected String getSQLInserir(Object t) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ALUNOS ");
		return null;
	}

	@Override
	protected String getSQLAlterar(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSQLRemover(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


	
	
}
