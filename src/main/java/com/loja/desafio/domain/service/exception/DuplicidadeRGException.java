package com.loja.desafio.domain.service.exception;

public class DuplicidadeRGException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DuplicidadeRGException() {

	}
	
	public DuplicidadeRGException(String msg) {
		super(msg);
	}

}
