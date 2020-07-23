package com.loja.desafio.domain.service.exception;

public class DuplicidadeNomeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DuplicidadeNomeException() {

	}
	
	public DuplicidadeNomeException(String msg) {
		super(msg);
	}

}
