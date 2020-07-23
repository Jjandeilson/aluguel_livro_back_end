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
import com.loja.desafio.domain.model.Livro;
import com.loja.desafio.domain.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Livro> buscar() {
		return livroService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Livro livro = livroService.buscar(id);
		return ResponseEntity.ok(livro);
	}
	
	@GetMapping("/buscar")
	public List<Livro> buscarPeloNome(@RequestParam("nome") String nome) {
		return livroService.buscarPeloNome(nome);
	}
	
	@PostMapping
	public ResponseEntity<Livro> salvar(@RequestBody @Valid Livro livro, HttpServletResponse response) {
		Livro livroSalvo = livroService.salvar(livro);
		publisher.publishEvent(new LojaEvent(livroSalvo.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody @Valid Livro livro) {
		Livro livroAtualizado = livroService.atualizar(id, livro);
		return ResponseEntity.ok(livroAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		livroService.remover(id);
		return ResponseEntity.noContent().build();
	}
}
