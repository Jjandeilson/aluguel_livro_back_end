package com.loja.desafio.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	@Size(min = 6, max = 70)
	private String nome;
	
	@NotBlank
	@Size(min = 6, max = 70)
	private String autor;
	
	@Column(name = "data_lancamento")
	@NotNull
	private LocalDate dataLancamento;
	
	@NotBlank
	private String genero;
	
	@Positive
	private Integer quantidade;
}
