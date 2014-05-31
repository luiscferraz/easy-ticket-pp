package br.ufrpe.easyticket.cargo.dominio;

public class Cargo {
	private int idCargo;
    private String nome;
    
	public Cargo(int idCargo, String nome) {
		super();
		this.idCargo = idCargo;
		this.nome = nome;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", nome=" + nome + "]";
	}
	
	
    
    

}
