package br.ufrpe.easyticket.infra.persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

import br.ufrpe.easyticket.infra.excecao.MyObjectRuntimeException;

public class Util {
	/**
	 * Formatador para pegar dia, mês e ano (4 dígitos)
	 */
	public final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Formatador para pegar dia, mês, ano (4 dígitos), hora (24h), minuto e segundo.
	 */
	public final SimpleDateFormat TIMESTAMP_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	//Implementação do Singleton
	private static Util instance = new Util();
	
	private Util() {
		//não faz nada
	}
	
	public static Util getInstance() {
		return instance;
	}
	//Fim da implementação do Singleton
	
	
	/**
	 * Formata a data no formato de dia, mês e ano (4 dígitos)
	 * @param date a data
	 * @return uma String com o data formatada
	 */
	public String formatDate(Date date) {
		return this.format(date, DATE_FORMATTER);
	}
	
	/**
	 * Cria uma data, a partir de uma String no formato de dia, mês e ano (4 dígitos)
	 * @param date a string
	 * @return uma data
	 */
	public Date parseDate(String date) {
		return this.parse(date, DATE_FORMATTER);
	}
	
	/**
	 * Formata a data no formato de dia, mês, ano (4 dígitos), hora (24h), minutos e segundos
	 * @param date a data
	 * @return uma String com o data formatada
	 */
	public String formatTimestamp(Date date) {
		return this.format(date, TIMESTAMP_FORMATTER);
	}
	
	/**
	 * Cria uma data, a partir de uma String no formato de dia, mês, ano (4 dígitos), hora (24h), minutos e segundos
	 * @param date a string
	 * @return uma data
	 */
	public Date parseTimestamp(String date) {
		return this.parse(date, TIMESTAMP_FORMATTER);
	}
	
	/**
	 * Formata uma data com base na data e no formatador passado como parâmetro. 
	 * Caso os formatos do <code>sdf</code> e do <code>date</code> não sejam equivalentes,
	 * será lançada uma {@link MPOORuntimeException}. 
	 * @param date a string
	 * @param sdf o formatador
	 * @return a data
	 */
	public String format(Date date, SimpleDateFormat sdf) {
		if (date == null || sdf == null) {
			return null;
		}
		return sdf.format(date);
	}

	/**
	 * Cria uma data com base na string e no formatador passado como parâmetro. 
	 * Caso os formatos do <code>sdf</code> e do <code>date</code> não sejam equivalentes,
	 * será lançada uma {@link MPOORuntimeException}. 
	 * @param date a string
	 * @param sdf o formatador
	 * @return a data
	 */
	public Date parse(String date, SimpleDateFormat sdf) {
		if (date == null || sdf == null) {
			return null;
		}
		
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			throw new MyObjectRuntimeException("Erro ao converter a data", e);
		}
	}

	/**
	 * Checa se o CPF informado é válido. Algoritmo obtido em http://javanamente.blogspot.com.br/2011/10/algoritimo-para-validar-cpf-segundo.html.
	 * @param cpf o cpf
	 * @return <code>true</code> se for válido e <code>false</code> caso contrário.
	 */
	public boolean isCPFValido(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") 
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") 
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") 
				|| cpf.equals("99999999999") || cpf.length() != 11) {
			return false;
		}
		
		boolean result = false;
		try { 
			// Calculo do 1o. Digito Verificador 
			int sm = 0; 
			int peso = 10; 
			for (int i=0; i<9; i++) { 
				// converte o i-esimo caractere do CPF em um numero: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posicao de '0' na tabela ASCII) 
				int num = (int)(cpf.charAt(i) - 48); 
				sm = sm + (num * peso); peso = peso - 1; 
			} 
	
			int dig10;
			int r = 11 - (sm % 11); 
			if (r == 10 || r == 11) {
				dig10 = '0';  
			} else {
				dig10 = (char)(r + 48); // converte no respectivo caractere numerico
			}
	
	
			// Calculo do 2o. Digito Verificador 
			sm = 0;
			peso = 11; 
			for(int i=0; i<10; i++) { 
				int num = (int)(cpf.charAt(i) - 48); 
				sm = sm + (num * peso); 
				peso = peso - 1; 
			}

			int dig11;
			r = 11 - (sm % 11);
			if (r == 10 || r == 11) { 
				dig11 = '0'; 
			} else {
				dig11 = (char)(r + 48);
			}

			// Verifica se os digitos calculados conferem com os digitos informados. 
			if (dig10 == cpf.charAt(9) && dig11 == cpf.charAt(10)) { 
				result = true; 
			}
				
		} catch (InputMismatchException erro) {
			//não faz nada (result já é false)
		}
		return result;
	}
	
	
	
	
	
	
}
