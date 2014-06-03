package br.ufrpe.easyticket.infra.persistencia;

import java.util.List;

import br.ufrpe.easyticket.infra.negocio.MyObject;

/**
 * Interface base para os DAOs . 
 * Cada classe deve implementar seus métodos. 
 * @author 
 */
public interface IGenericDAO<T extends MyObject> {
	
	
	/*void inserir(String updateSql, Object[] parametros);
	
	void alterar(String updateSql, Object[] parametros);
	
	void remover(String updateSql, Object[] parametros);
	*/
	
	
	
		/**
		 * Insere a instância <code>t</code>.
		 * @param t a instância.
		 * @return <code>true</code> se houver alguma alteração no mecanismo de persistência e <code>false</code> caso contrário.
		 */
		boolean inserir(T t);
		
		/**
		 * Altera a instância <code>t</code>.
		 * @param t a instância.
		 * @return <code>true</code> se houver alguma alteração no mecanismo de persistência e <code>false</code> caso contrário.
		 */
		boolean alterar(T t);
		
		/**
		 * Remove a instância <code>t</code> no banco.
		 * @param t a instância
		 * @return <code>true</code> se houver alguma alteração no mecanismo de persistência e <code>false</code> caso contrário
		 */
		boolean remover(T t);
		
		/**
		 * Retorna a instância de <code>T</code> com o id informado, ou <code>null</code>, caso não encontre.
		 * @param id o id.
		 * @return a instância de <code>T</code>.
		 */
		public T getById(int id);

		/**
		 * Retorna todas as intâncias de <code>T</code> armazenadas.
		 * @return as instâncias de T.
		 */
		public List<T> getAll();
		
	}
	

	


