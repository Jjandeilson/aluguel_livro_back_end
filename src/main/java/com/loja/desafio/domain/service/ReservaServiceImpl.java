package com.loja.desafio.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.loja.desafio.domain.model.Reserva;
import com.loja.desafio.domain.repository.ReservaRepository;
import com.loja.desafio.domain.service.validar.ValidarEntidade;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private ValidarEntidade validarEntidade;

	@Override
	public List<Reserva> listar() {
		return reservaRepository.listarDeReservas();
	}

	@Override
	public Reserva buscar(Long id) {
		return reservaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Reserva salvar(Reserva reserva) {
		validarEntidade.validarCliente(reserva.getCliente().getId());
		validarEntidade.validarLivro(reserva.getLivro().getId());
		return reservaRepository.save(reserva);
	}

	@Override
	public void remover(Long id) {
		Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		reservaRepository.delete(reserva);
	}

	@Override
	public Reserva atualizar(Long id, Reserva reserva) {
		Reserva reservaAtualizar = reservaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		validarEntidade.validarLivro(reserva.getLivro().getId());
		BeanUtils.copyProperties(reserva, reservaAtualizar, "id", "cliente", "livro");
		return reservaRepository.save(reservaAtualizar);
	}

}
