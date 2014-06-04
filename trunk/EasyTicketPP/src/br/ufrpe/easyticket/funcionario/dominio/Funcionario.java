package br.ufrpe.easyticket.funcionario.dominio;


import br.ufrpe.easyticket.cargo.dominio.Cargo;
import br.ufrpe.easyticket.infra.negocio.MyObject;
import br.ufrpe.easyticket.pessoa.dominio.Pessoa;


/**Esta classe representa um Funcionário
 * @author 
 *
 */
public class Funcionario  extends MyObject{
	/**
	 *A pessoa representa um funcionário.
	 */
	
	private Cargo cargo;
	private Pessoa pessoa;
	
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	

	
	
	
	
	
	 
	 
}
