package com.loja.desafio.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loja.desafio.api.event.LojaEvent;
import com.loja.desafio.domain.model.Aluguel;
import com.loja.desafio.domain.repository.AluguelRepository;
import com.loja.desafio.domain.repository.filter.AluguelFilter;
import com.loja.desafio.domain.service.AluguelService;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private AluguelService aluguelService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Aluguel> listar(){
		return aluguelService.listar();
	}
	
	@GetMapping("/{id}")
	public Aluguel buscar(@PathVariable Long id) {
		return aluguelService.buscar(id);
	}
	
	@GetMapping("/alugados")
	public List<Aluguel> alugados() {
		return aluguelService.listaDeLivrosAlugados();
	}
	
	@GetMapping("/buscar")
	public List<Aluguel> pesquisar(@RequestParam("rg") String rg) {
		return aluguelService.listarPorRg(rg);
	}
	
	@GetMapping("/devolucao")
	public List<Aluguel> pesquisarAluguelDevolucao(AluguelFilter aluguelFilter) {
		return aluguelRepository.filtrarPorDataEntrega(aluguelFilter);
	}
	
	@GetMapping("/alugado")
	public List<Aluguel> pesquisarAlugadoPorDia(AluguelFilter aluguelFilter) {
		return aluguelRepository.filtrarPorDataAlugado(aluguelFilter);
	}
	
	@PostMapping
	public ResponseEntity<Aluguel> salvar(@RequestBody @Valid Aluguel aluguel, HttpServletResponse response) {
		Aluguel aluguelSalvo  = aluguelService.salvar(aluguel);
		publisher.publishEvent(new LojaEvent(aluguelSalvo.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(aluguelSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluguel> atualizar(@PathVariable Long id,@RequestBody @Valid Aluguel aluguel) {
		Aluguel aluguelAtualizado = aluguelService.atualizar(id, aluguel);
		return ResponseEntity.ok(aluguelAtualizado);
	}
	
	@PutMapping("/{id}/devolucao")
	public void devolucao(@PathVariable Long id,@RequestBody Boolean devolucao) {
		aluguelService.devolucaoLivro(id, devolucao);
	}
}
