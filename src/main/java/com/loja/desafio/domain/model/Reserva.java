package com.loja.desafio.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@Column(name = "data_reserva")
	private LocalDate dataReserva;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;
}
