package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.OmeDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Ome;
import br.gov.pe.sismepe.ehospenterprise.filtro.OmeFiltro;

public class OmeDaoImpl implements OmeDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Ome, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	OmeDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Ome, Long>(Ome.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(Ome ome) {
		genericoDao.inserir(ome);
	}

	@Override
	public void remover(Ome ome) {
		genericoDao.remover(ome);		
	}

	@Override
	public void atualizar(Ome ome) {
		genericoDao.atualizar(ome);		
	}
	
	@Override
	public Ome pesquisarPorId(Long cdOme){
		return genericoDao.pesquisarPorID(cdOme);
	}

	@Override
	public List<Ome> listarOmes() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<Ome> pesquisarOmes(OmeFiltro omeFiltro) {
		return entityManager.createQuery("from Ome where upper(dsOme) like :dsOme",Ome.class).
				setParameter("dsOme", "%" + omeFiltro.getDsOme().toUpperCase() + "%").
				getResultList();
	}
}
