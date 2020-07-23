package com.loja.desafio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loja.desafio.domain.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

	@Query("from Reserva r join fetch r.cliente join fetch r.livro")
	List<Reserva> listarDeReservas();
}
