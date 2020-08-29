package com.laratecsys.inpaktaService.Service.exception;

public class ConstraitException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ConstraitException(String nome) {
		super(nome);
	}
	
	public ConstraitException(String nome, Throwable cause) {
		super(nome, cause);
	}
}
