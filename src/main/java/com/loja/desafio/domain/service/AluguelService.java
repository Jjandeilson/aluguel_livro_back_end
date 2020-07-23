package com.loja.desafio.domain.service;

import java.util.List;

import com.loja.desafio.domain.model.Aluguel;

public interface AluguelService {

	List<Aluguel> listar();
	Aluguel buscar(Long id);
	Aluguel salvar(Aluguel aluguel);
	Aluguel atualizar(Long id, Aluguel aluguel);
	void devolucaoLivro(Long id, Boolean devolucao);
	List<Aluguel> listaDeLivrosAlugados();
	List<Aluguel> listarPorRg(String rg);
}
