package com.loja.desafio.domain.service;

import java.util.List;

import com.loja.desafio.domain.model.Reserva;

public interface ReservaService {

	List<Reserva> listar();
	Reserva buscar(Long id);
	Reserva salvar(Reserva reserva);
	void remover(Long id);
	Reserva atualizar(Long id, Reserva reserva);
}
