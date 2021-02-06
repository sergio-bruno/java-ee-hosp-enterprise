package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.CidadeDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cidade;

public class CidadeDaoImpl implements CidadeDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Cidade, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	CidadeDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Cidade, Long>(Cidade.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public Cidade pesquisarPorId(Long cdCidade){
		return genericoDao.pesquisarPorID(cdCidade);
	}

	@Override
	public List<Cidade> listarCidades() {
		return genericoDao.listarTodos();
	}
	
	@Override
	public List<Cidade> pesquisarCidades(String descricao) {
		return entityManager.createQuery("from Cidade where upper(dsCidade) like :dsCidade",Cidade.class).
				setParameter("dsCidade", "%" + descricao.toUpperCase() + "%").
				getResultList();
	}
	
}
