package com.rodrigo.seguranca.servicos.excessao;

public class NaoAutorizadoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NaoAutorizadoException(String mensagem) {
		super(mensagem);
	}

}
