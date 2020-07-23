package com.loja.desafio.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.desafio.domain.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findById(Long id);
	List<Livro> findByNomeContaining(String nome);
	Optional<Livro> findConsultaByNomeContaining(String nome);
}
