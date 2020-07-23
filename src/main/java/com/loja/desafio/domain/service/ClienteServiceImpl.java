package com.loja.desafio.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.loja.desafio.domain.model.Cliente;
import com.loja.desafio.domain.repository.ClienteRepository;
import com.loja.desafio.domain.service.exception.DuplicidadeRGException;
import com.loja.desafio.domain.service.exception.EntidadeEmUsoException;
import com.loja.desafio.domain.service.validar.ValidarEntidade;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ValidarEntidade validarEntidade;

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscar(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Cliente salvar(Cliente cliente) {
		try {
			return clienteRepository.save(cliente);
		}catch(DataIntegrityViolationException ex) {
			throw new DuplicidadeRGException(ex.getMessage());
		}
	}

	@Override
	public void remover(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		try {
			clienteRepository.delete(cliente);
		}catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(ex.getMessage());
		}
	}

	@Override
	public Cliente atualizar(Long id, Cliente cliente) {
		validarEntidade.validarRGDuplicado(id, cliente.getRg());
		
		Cliente clienteAtualizar = clienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(cliente, clienteAtualizar, "id");
		return clienteRepository.save(clienteAtualizar);
	}

	@Override
	public Cliente busarPeloRg(String rg) {
		return clienteRepository.findByRg(rg).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
