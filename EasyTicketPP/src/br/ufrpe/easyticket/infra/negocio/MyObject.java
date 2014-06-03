package br.ufrpe.easyticket.infra.negocio;

import java.util.Iterator;
import java.util.List;

public class MyObject {
	/**
	 * O id do objeto
	 */
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Procura o objeto que tenha o identificador com o valor informado em 
	 * <code>id</code>, dentro da coleção <code>objetos</code> e o remove.
	 * @param objetos
	 * @param id
	 * @return o objeto removido, ou <code>null</code>, caso não encontre.
	 */
	public <T extends MyObject> T remove(List<T> objetos, int id) {
		for (Iterator<T> iterator = objetos.iterator(); iterator.hasNext();) {
			T t = iterator.next();
			if (t.getId() == id) {
				iterator.remove();
				//TODO
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Procura o objeto que tenha o identificador com o valor informado em 
	 * <code>id</code>, dentro da coleção <code>objetos</code>.
	 * @param objetos
	 * @param id
	 * @return o objeto, ou <code>null</code>, caso não encontre.
	 */
	public <T extends MyObject> T getPorId(List<T> objetos, int id) {
		for (Iterator<T> iterator = objetos.iterator(); iterator.hasNext();) {
			T t = iterator.next();
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}
	
	@Override
	public int hashCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().toString());
		sb.append(this.getId());
		return sb.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		MyObject that = (MyObject)obj;
		boolean result = false;
		if (that != null) {
			result = this == that || this.getId() == that.getId();
		}
		return result;
	}
}
