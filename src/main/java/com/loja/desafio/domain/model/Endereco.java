package com.loja.desafio.domain.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Embeddable
@Data
public class Endereco {
	
	@Size(min = 4, max = 50)
	@NotBlank
	private String cidade;
	
	@Size(min = 10, max = 60)
	@NotBlank
	private String logradouro;
	
	@Size(min = 6, max = 40)
	@NotBlank
	private String bairro;
	
	@Size(max = 2)
	@NotBlank
	private String estado;
	
	@Size(max = 10)
	@NotBlank
	private String cep;
	
	private String numero;
	
	private String complemento;
}
