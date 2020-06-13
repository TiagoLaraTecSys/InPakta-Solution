package com.laratecsys.inpaktaService.Service.exception;

public class AuthorizationException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public AuthorizationException(String nome) {
		super(nome);
	}
	
	public AuthorizationException(String nome, Throwable cause) {
		super(nome,cause);
	}

}
