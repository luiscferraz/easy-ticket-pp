package br.ufrpe.easyticket.aluno.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrpe.easyticket.infra.negocio.MyObject;
import br.ufrpe.easyticket.infra.persistencia.GenericDAO;

public class AlunoDAO extends GenericDAO  {

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

	@Override
	public boolean inserir(MyObject t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(MyObject t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(MyObject t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object convert(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	


	
	
}
