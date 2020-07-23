package com.loja.desafio.domain.service;

import java.util.List;

import com.loja.desafio.domain.model.Livro;

public interface LivroService {

	List<Livro> listar();
	List<Livro> buscarPeloNome(String nome);
	Livro buscar(Long id);
	Livro salvar(Livro livro);
	void remover(Long id);
	Livro atualizar(Long id, Livro livro);	
}
