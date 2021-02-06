package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.UnidadeMedidaDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.UnidadeMedida;
import br.gov.pe.sismepe.ehospenterprise.filtro.UnidadeMedidaFiltro;

public class UnidadeMedidaDaoImpl implements UnidadeMedidaDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<UnidadeMedida, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	UnidadeMedidaDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<UnidadeMedida, Long>(UnidadeMedida.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(UnidadeMedida unidadeMedida) {
		genericoDao.inserir(unidadeMedida);
	}

	@Override
	public void remover(UnidadeMedida unidadeMedida) {
		genericoDao.remover(unidadeMedida);		
	}

	@Override
	public void atualizar(UnidadeMedida unidadeMedida) {
		genericoDao.atualizar(unidadeMedida);		
	}
	
	@Override
	public UnidadeMedida pesquisarPorId(Long cdUnidadeMedida){
		return genericoDao.pesquisarPorID(cdUnidadeMedida);
	}

	@Override
	public List<UnidadeMedida> listarUnidadeMedidas() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<UnidadeMedida> pesquisarUnidadeMedidas(UnidadeMedidaFiltro unidadeMedidaFiltro) {
		return entityManager.createQuery("from UnidadeMedida where upper(dsUnidadeMedida) like :dsUnidadeMedida",UnidadeMedida.class).
				setParameter("dsUnidadeMedida", "%" + unidadeMedidaFiltro.getDsUnidadeMedida().toUpperCase() + "%").
				getResultList();
	}
}
