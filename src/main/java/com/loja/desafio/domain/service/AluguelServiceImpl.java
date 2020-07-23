package com.loja.desafio.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.loja.desafio.domain.model.Aluguel;
import com.loja.desafio.domain.model.Livro;
import com.loja.desafio.domain.repository.AluguelRepository;
import com.loja.desafio.domain.repository.LivroRepository;
import com.loja.desafio.domain.service.validar.ValidarEntidade;

@Service
public class AluguelServiceImpl implements AluguelService{

	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ValidarEntidade validarEntidade;
	

	@Override
	public List<Aluguel> listar() {
		return aluguelRepository.listaTodosAlugueis();
	}

	@Override
	public Aluguel buscar(Long id) {
		return aluguelRepository.buscarPorId(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Aluguel salvar(Aluguel aluguel) {
		validarEntidade.validarCliente(aluguel.getCliente().getId());
		validarEntidade.validarLivro(aluguel.getLivro().getId());
		
		Livro livro = livroRepository.getOne(aluguel.getLivro().getId());
		validarEntidade.validarQuantidadeLivro(livro);
		
		int quantidade = livro.getQuantidade();
		livro.setQuantidade(quantidade - 1);
		aluguel.setLivro(livro);
		return aluguelRepository.save(aluguel);
	}

	@Override
	public Aluguel atualizar(Long id, Aluguel aluguel) {
		Aluguel aluguelAtualizar = aluguelRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(aluguel, aluguelAtualizar, "id", "livro", "cliente", "alugado");
		return aluguelRepository.save(aluguelAtualizar);
	}
	
	@Override
	public void devolucaoLivro(Long id, Boolean devolucao) {
		Aluguel aluguel = aluguelRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		Livro livro = aluguel.getLivro();
		int quantidade = livro.getQuantidade();
		livro.setQuantidade(quantidade + 1);
		aluguel.setLivro(livro);
		aluguel.setAlugado(devolucao);
		aluguelRepository.save(aluguel);
	}
	
	@Override
	public List<Aluguel> listaDeLivrosAlugados() {
		return aluguelRepository.listaDeAlugados();
	}

	@Override
	public List<Aluguel> listarPorRg(String rg) {
		return aluguelRepository.pesquisarAluguelPorRG(rg);
	}

}
