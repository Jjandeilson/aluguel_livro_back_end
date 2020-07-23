package com.loja.desafio.domain.repository.alguel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.loja.desafio.domain.model.Aluguel;
import com.loja.desafio.domain.repository.filter.AluguelFilter;

@Service
public class AluguelRepositoryQueryImpl implements AluguelRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Aluguel> filtrarPorDataEntrega(AluguelFilter aluguelFilter) {
		TypedQuery<Aluguel> query = manager.createQuery("from Aluguel a join fetch a.livro join fetch a.cliente "
				+ "where a.dataEntrega = :data and a.alugado = true", Aluguel.class)
				.setParameter("data", aluguelFilter.getDataEntrega());
		return query.getResultList();
	}

	@Override
	public List<Aluguel> filtrarPorDataAlugado(AluguelFilter aluguelFilter) {
		TypedQuery<Aluguel> query = manager.createQuery("from Aluguel a join fetch a.livro join fetch a.cliente "
				+ "where a.dataInicio = :data and a.alugado = true", Aluguel.class)
				.setParameter("data", aluguelFilter.getDataInicio());
		return query.getResultList();
	}


}
