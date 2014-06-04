package br.ufrpe.easyticket.infra.excecao;


public class MyObjectException extends Exception{
	public MyObjectException(String mensagem) {
		super(mensagem);
	}
	public MyObjectException(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
}
