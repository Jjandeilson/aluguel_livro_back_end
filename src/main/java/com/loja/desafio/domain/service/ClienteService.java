package com.loja.desafio.domain.service;

import java.util.List;

import com.loja.desafio.domain.model.Cliente;

public interface ClienteService {

	List<Cliente> listar();
	Cliente busarPeloRg(String rg);
	Cliente buscar(Long id);
	Cliente salvar(Cliente cliente);
	void remover(Long id);
	Cliente atualizar(Long id, Cliente cliente);
}
