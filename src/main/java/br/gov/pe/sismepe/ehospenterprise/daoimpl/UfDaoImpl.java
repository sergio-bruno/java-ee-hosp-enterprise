package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.UfDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Uf;

public class UfDaoImpl implements UfDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Uf, String> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	UfDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Uf, String>(Uf.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public Uf pesquisarPorId(String cdUf){
		return genericoDao.pesquisarPorID(cdUf);
	}

	@Override
	public List<Uf> listarUfs() {
		return genericoDao.listarTodos();
	}
	
	@Override
	public List<Uf> pesquisarUfs(String descricao) {
		return entityManager.createQuery("from Uf where upper(dsUf) like :dsUf",Uf.class).
				setParameter("dsUf", "%" + descricao.toUpperCase() + "%").
				getResultList();
	}
	
}
