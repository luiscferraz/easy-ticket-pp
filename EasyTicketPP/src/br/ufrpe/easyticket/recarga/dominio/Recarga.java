package br.ufrpe.easyticket.recarga.dominio;

import br.ufrpe.easyticket.cartao.dominio.Cartao;

public class Recarga {
	
	private int id;
	private float valor;
	private java.sql.Date data;
	private Cartao cartao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public java.sql.Date getData() {
		return data;
	}
	public void setData(java.sql.Date data) {
		this.data = data;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	

}
