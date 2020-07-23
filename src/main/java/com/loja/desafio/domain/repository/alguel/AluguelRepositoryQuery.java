package com.loja.desafio.domain.repository.alguel;

import java.util.List;

import com.loja.desafio.domain.model.Aluguel;
import com.loja.desafio.domain.repository.filter.AluguelFilter;

public interface AluguelRepositoryQuery {

	List<Aluguel> filtrarPorDataEntrega(AluguelFilter aluguelFilter);
	List<Aluguel> filtrarPorDataAlugado(AluguelFilter aluguelFilter);
}
