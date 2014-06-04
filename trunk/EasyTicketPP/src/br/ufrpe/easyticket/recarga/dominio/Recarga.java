package br.ufrpe.easyticket.recarga.dominio;

import br.ufrpe.easyticket.cartao.dominio.Cartao;
import br.ufrpe.easyticket.infra.negocio.MyObject;

public class Recarga extends MyObject{
	private float valor;
	private java.sql.Date data;
	private Cartao cartao;
	
	
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
