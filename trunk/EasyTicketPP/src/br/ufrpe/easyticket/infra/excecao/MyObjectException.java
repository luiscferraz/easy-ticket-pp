package br.ufrpe.easyticket.infra.excessao;


public class MyObjectException extends Exception{
	public MyObjectException(String mensagem) {
		super(mensagem);
	}
	public MyObjectException(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
}
