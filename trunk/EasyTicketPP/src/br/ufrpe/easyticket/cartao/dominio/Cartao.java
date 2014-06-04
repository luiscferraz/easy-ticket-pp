package br.ufrpe.easyticket.cartao.dominio;

import br.ufrpe.easyticket.aluno.dominio.Aluno;
import br.ufrpe.easyticket.infra.negocio.MyObject;

public class Cartao extends MyObject{
	
	public enum StatusCartao{
		ATIVO,INATIVO,BLOQUEADO
	}
	
	
	private float saldo;
	private StatusCartao status;
	private Aluno aluno;
	
		
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
		return "Cartao [saldo=" + saldo + ", status=" + status + ", aluno="
				+ aluno + "]";
	}
	
	
	
	
	
	
	
	
	

}
