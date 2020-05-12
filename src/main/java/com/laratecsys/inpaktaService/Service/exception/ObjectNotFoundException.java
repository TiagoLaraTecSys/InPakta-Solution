package com.laratecsys.inpaktaService.Service.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String nome) {
		super(nome);
	}
	
	public ObjectNotFoundException(String nome, Throwable cause) {
		super(nome,cause);
	}

}
