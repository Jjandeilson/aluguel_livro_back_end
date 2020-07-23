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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loja.desafio.api.event.LojaEvent;
import com.loja.desafio.domain.model.Cliente;
import com.loja.desafio.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Cliente cliente = clienteService.buscar(id);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Cliente> buscarPeloRg(@RequestParam("rg") String rg) {
		Cliente cliente = clienteService.busarPeloRg(rg);
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody @Valid Cliente cliente, HttpServletResponse response) {
		Cliente clienteSalvo = clienteService.salvar(cliente);
		publisher.publishEvent(new LojaEvent(clienteSalvo.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
		Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(clienteAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		clienteService.remover(id);
		return ResponseEntity.noContent().build();
	}
}
