package com.loja.desafio.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "aluguel")
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@Column(name = "data_inicio")
	private LocalDate dataInicio;
	
	@NotNull
	@Column(name = "data_entrega")
	private LocalDate dataEntrega;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "livro_id")
	private Livro livro;
	
	@Positive
	private BigDecimal valor;
	
	@NotNull
	private Boolean alugado;
}
