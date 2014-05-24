package negocio;

import java.sql.Date;

public class Pessoa {
	private int id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private java.sql.Date dataNascimento;
    private String status;
    
	public Pessoa(int id, String nome, String email, String cpf,
			String telefone, Date dataNascimento, String status) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public java.sql.Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", cpf=" + cpf + ", telefone=" + telefone
				+ ", dataNascimento=" + dataNascimento + ", status=" + status
				+ "]";
	}
	
	public boolean isAtivo(Pessoa pessoa){
		if(this.status.equals(EnumStatus.ATIVO)){
			return true;
		}else{
			return false;
		}
	}
	
	
    
    
    
    
}
