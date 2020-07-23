package com.loja.desafio.api.event;

import javax.servlet.http.HttpServletResponse;

import lombok.Getter;

@Getter
public class LojaEvent {

	private Long id;
	private HttpServletResponse response;
	
	public LojaEvent(Long id, HttpServletResponse response) {
		this.id = id;
		this.response = response;
	}
	
}
