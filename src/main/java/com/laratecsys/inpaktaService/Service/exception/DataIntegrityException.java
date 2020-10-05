package com.laratecsys.inpaktaService.Service.exception;

public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String nome) {
		super(nome);
	}
	
	public DataIntegrityException(String nome, Throwable cause) {
		super(nome,cause);
	}

}
