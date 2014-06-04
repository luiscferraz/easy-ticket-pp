package br.ufrpe.easyticket.infra.excecao;

public class MyObjectRuntimeException extends RuntimeException {
	
	public MyObjectRuntimeException(String mensagem, Throwable causa) {
		super(mensagem);
	}
	
	public MyObjectRuntimeException(String mensagem){
		super(mensagem);
	}
	
	public MyObjectRuntimeException(Throwable causa) {
		this("Ocorreu um erro de sistema", causa);
	}

}
