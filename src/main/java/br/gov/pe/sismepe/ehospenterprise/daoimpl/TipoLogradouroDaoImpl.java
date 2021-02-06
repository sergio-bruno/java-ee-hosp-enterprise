package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.TipoLogradouroDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.TipoLogradouro;

public class TipoLogradouroDaoImpl implements TipoLogradouroDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<TipoLogradouro, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	TipoLogradouroDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<TipoLogradouro, Long>(TipoLogradouro.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public TipoLogradouro pesquisarPorId(Long cdTipoLogradouro){
		return genericoDao.pesquisarPorID(cdTipoLogradouro);
	}

	@Override
	public List<TipoLogradouro> listarTipoLogradouros() {
		return genericoDao.listarTodos();
	}
	
	@Override
	public List<TipoLogradouro> pesquisarTipoLogradouros(String descricao) {
		return entityManager.createQuery("from TipoLogradouro where upper(dsTipoLogradouro) like :dsTipoLogradouro",TipoLogradouro.class).
				setParameter("dsTipoLogradouro", "%" + descricao.toUpperCase() + "%").
				getResultList();
	}
	
}
