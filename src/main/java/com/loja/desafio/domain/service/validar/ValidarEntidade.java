package com.loja.desafio.domain.service.validar;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loja.desafio.domain.model.Cliente;
import com.loja.desafio.domain.model.Livro;
import com.loja.desafio.domain.repository.ClienteRepository;
import com.loja.desafio.domain.repository.LivroRepository;
import com.loja.desafio.domain.service.exception.DuplicidadeNomeException;
import com.loja.desafio.domain.service.exception.DuplicidadeRGException;
import com.loja.desafio.domain.service.exception.EntidadeInvalidaException;
import com.loja.desafio.domain.service.exception.QuantidadeInsuficiente;

@Component
public class ValidarEntidade {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void validarCliente(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(!cliente.isPresent()) {
			throw new EntidadeInvalidaException();
		}
	}
	
	public void validarRGDuplicado(Long id, String rg) {
		Optional<Cliente> cliente = clienteRepository.findByRg(rg);
		if(cliente.isPresent() && id != cliente.get().getId()) {
			throw new DuplicidadeRGException();
		}
	}
	
	public void validarLivro(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if(!livro.isPresent()) {
			throw new EntidadeInvalidaException();
		}
	}
	
	public void validarNomeLivroDuplicado(Long id, String nome) {
		Optional<Livro> livro = livroRepository.findConsultaByNomeContaining(nome);
		if(livro.isPresent() && id != livro.get().getId()) {
			throw new DuplicidadeNomeException();
		}
	}
	
	public void validarQuantidadeLivro(Livro livro) {
		if(livro.getQuantidade() == 0) {
			throw new QuantidadeInsuficiente();
		}
	}
}
