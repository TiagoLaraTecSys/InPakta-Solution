package com.laratecsys.inpaktaService.Service.exception;

public class MethodArgumentNotValidException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public MethodArgumentNotValidException(String nome) {
		super(nome);
	}
	
	public MethodArgumentNotValidException(String nome, Throwable cause) {
		super(nome,cause);
	}

}
