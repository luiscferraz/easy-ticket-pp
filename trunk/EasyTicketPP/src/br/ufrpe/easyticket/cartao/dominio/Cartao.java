package br.ufrpe.easyticket.cartao.dominio;

import br.ufrpe.easyticket.aluno.dominio.Aluno;

public class Cartao {
	
	public enum StatusCartao{
		ATIVO,INATIVO,BLOQUEADO
	}
	
	private int id;
	private float saldo;
	private StatusCartao status;
	private Aluno aluno;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public StatusCartao getStatus() {
		return status;
	}
	public void setStatus(StatusCartao status) {
		this.status = status;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Override
	public String toString() {
		return "Cartao [id=" + id + ", saldo=" + saldo + ", status=" + status
				+ ", aluno=" + aluno + "]";
	}
	
	
	
	
	
	
	

}
