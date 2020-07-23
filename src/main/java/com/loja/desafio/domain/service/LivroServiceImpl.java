package com.loja.desafio.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.loja.desafio.domain.model.Livro;
import com.loja.desafio.domain.repository.LivroRepository;
import com.loja.desafio.domain.service.exception.DuplicidadeNomeException;
import com.loja.desafio.domain.service.exception.EntidadeEmUsoException;
import com.loja.desafio.domain.service.validar.ValidarEntidade;

@Service
public class LivroServiceImpl implements LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ValidarEntidade validarEntidade;

	@Override
	public List<Livro> listar() {
		return livroRepository.findAll();
	}

	@Override
	public Livro buscar(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Livro salvar(Livro livro) {
		try {
			return livroRepository.save(livro);
		}catch(DataIntegrityViolationException ex) {
			throw new DuplicidadeNomeException(ex.getMessage());
		}
		
	}

	@Override
	public void remover(Long id) {
		Livro livro = livroRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		try {			
			livroRepository.delete(livro);
		}catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(ex.getMessage());
		}
	}

	@Override
	public Livro atualizar(Long id, Livro livro) {
		validarEntidade.validarNomeLivroDuplicado(id, livro.getNome());
		Livro livroAtualizar = livroRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(livro, livroAtualizar, "id");
		return livroRepository.save(livroAtualizar);
	}

	@Override
	public List<Livro> buscarPeloNome(String nome) {
		return livroRepository.findByNomeContaining(nome);
	}
}
