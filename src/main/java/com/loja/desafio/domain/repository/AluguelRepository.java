package com.loja.desafio.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loja.desafio.domain.model.Aluguel;
import com.loja.desafio.domain.repository.alguel.AluguelRepositoryQuery;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long>, AluguelRepositoryQuery{

	@Query("from Aluguel a join fetch a.livro join fetch a.cliente where a.alugado = true")
	List<Aluguel> listaDeAlugados();
	
	@Query("from Aluguel a join fetch a.livro join fetch a.cliente")
	List<Aluguel> listaTodosAlugueis();
		
	@Query("from Aluguel a join fetch a.livro join fetch a.cliente where a.cliente.rg = :rg")
	List<Aluguel> pesquisarAluguelPorRG(@Param("rg") String rg);
	
	@Query("from Aluguel a join fetch a.livro join fetch a.cliente where a.id = :id")
	Optional<Aluguel> buscarPorId(@Param("id") Long id);
}
