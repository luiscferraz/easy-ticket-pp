package br.ufrpe.easyticket.infra.persistencia;

import java.util.List;

import br.ufrpe.easyticket.infra.negocio.MyObject;

/**
 * Interface base para os DAOs . 
 * Cada classe deve implementar seus m�todos. 
 * @author 
 */
public interface IGenericDAO<T extends MyObject> {
	
	
	/*void inserir(String updateSql, Object[] parametros);
	
	void alterar(String updateSql, Object[] parametros);
	
	void remover(String updateSql, Object[] parametros);
	*/
	
	
	
		/**
		 * Insere a inst�ncia <code>t</code>.
		 * @param t a inst�ncia.
		 * @return <code>true</code> se houver alguma altera��o no mecanismo de persist�ncia e <code>false</code> caso contr�rio.
		 */
		boolean inserir(T t);
		
		/**
		 * Altera a inst�ncia <code>t</code>.
		 * @param t a inst�ncia.
		 * @return <code>true</code> se houver alguma altera��o no mecanismo de persist�ncia e <code>false</code> caso contr�rio.
		 */
		boolean alterar(T t);
		
		/**
		 * Remove a inst�ncia <code>t</code> no banco.
		 * @param t a inst�ncia
		 * @return <code>true</code> se houver alguma altera��o no mecanismo de persist�ncia e <code>false</code> caso contr�rio
		 */
		boolean remover(T t);
		
		/**
		 * Retorna a inst�ncia de <code>T</code> com o id informado, ou <code>null</code>, caso n�o encontre.
		 * @param id o id.
		 * @return a inst�ncia de <code>T</code>.
		 */
		public T getById(int id);

		/**
		 * Retorna todas as int�ncias de <code>T</code> armazenadas.
		 * @return as inst�ncias de T.
		 */
		public List<T> getAll();
		
	}
	

	


