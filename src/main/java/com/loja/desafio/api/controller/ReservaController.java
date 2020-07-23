package com.loja.desafio.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.desafio.api.event.LojaEvent;
import com.loja.desafio.domain.model.Reserva;
import com.loja.desafio.domain.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Reserva> listar() {
		return reservaService.listar();
	}
	
	@GetMapping("/{id}")
	public Reserva buscar(@PathVariable Long id) {
		return reservaService.buscar(id);
	}
	
	@PostMapping
	public ResponseEntity<Reserva> salvar(@RequestBody @Valid Reserva reserva, HttpServletResponse response) {
		Reserva reservaSalva = reservaService.salvar(reserva);
		publisher.publishEvent(new LojaEvent(reservaSalva.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaSalva);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		reservaService.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reserva> atualizar(@PathVariable Long id, @RequestBody @Valid Reserva reserva) {
		Reserva reservaAtualizada = reservaService.atualizar(id, reserva);
		return ResponseEntity.ok(reservaAtualizada);
	}
}
