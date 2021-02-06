package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.ConselhoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Conselho;
import br.gov.pe.sismepe.ehospenterprise.filtro.ConselhoFiltro;

public class ConselhoDaoImpl implements ConselhoDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Conselho, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	ConselhoDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Conselho, Long>(Conselho.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(Conselho conselho) {
		genericoDao.inserir(conselho);
	}

	@Override
	public void remover(Conselho conselho) {
		genericoDao.remover(conselho);		
	}

	@Override
	public void atualizar(Conselho conselho) {
		genericoDao.atualizar(conselho);		
	}
	
	@Override
	public Conselho pesquisarPorId(Long cdConselho){
		return genericoDao.pesquisarPorID(cdConselho);
	}

	@Override
	public List<Conselho> listarConselhos() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<Conselho> pesquisarConselhos(ConselhoFiltro conselhoFiltro) {
		return entityManager.createQuery("from Conselho where upper(dsConselho) like :dsConselho",Conselho.class).
				setParameter("dsConselho", "%" + conselhoFiltro.getDsConselho().toUpperCase() + "%").
				getResultList();
	}
}
