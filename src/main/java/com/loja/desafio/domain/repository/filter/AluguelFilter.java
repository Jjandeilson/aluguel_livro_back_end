package com.loja.desafio.domain.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AluguelFilter {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEntrega;
}
