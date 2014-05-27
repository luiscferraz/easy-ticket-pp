package negocio;

import java.sql.Date;

public class Funcionario extends Pessoa {
	 private int idCargo;

	public Funcionario(int id, String nome, String email, String cpf,
			String telefone, Date dataNascimento, String status,int idCargo) {
		super(id, nome, email, cpf, telefone, dataNascimento, status);
		this.idCargo=idCargo;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	
	
	 
	 
}
