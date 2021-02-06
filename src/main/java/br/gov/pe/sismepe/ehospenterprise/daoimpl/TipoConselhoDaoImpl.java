package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.TipoConselhoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.TipoConselho;
import br.gov.pe.sismepe.ehospenterprise.filtro.TipoConselhoFiltro;

public class TipoConselhoDaoImpl implements TipoConselhoDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<TipoConselho, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	TipoConselhoDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<TipoConselho, Long>(TipoConselho.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(TipoConselho tipoConselho) {
		genericoDao.inserir(tipoConselho);
	}

	@Override
	public void remover(TipoConselho tipoConselho) {
		genericoDao.remover(tipoConselho);		
	}

	@Override
	public void atualizar(TipoConselho tipoConselho) {
		genericoDao.atualizar(tipoConselho);		
	}
	
	@Override
	public TipoConselho pesquisarPorId(Long cdTipoConselho){
		return genericoDao.pesquisarPorID(cdTipoConselho);
	}

	@Override
	public List<TipoConselho> listarTipoConselhos() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<TipoConselho> pesquisarTipoConselhos(TipoConselhoFiltro tipoConselhoFiltro) {
		return entityManager.createQuery("from TipoConselho where upper(dsTipoConselho) like :dsTipoConselho",TipoConselho.class).
				setParameter("dsTipoConselho", "%" + tipoConselhoFiltro.getDsTipoConselho().toUpperCase() + "%").
				getResultList();
	}
}
