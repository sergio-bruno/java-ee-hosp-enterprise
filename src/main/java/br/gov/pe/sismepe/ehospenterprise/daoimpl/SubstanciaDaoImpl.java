package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.SubstanciaDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Substancia;
import br.gov.pe.sismepe.ehospenterprise.filtro.SubstanciaFiltro;

public class SubstanciaDaoImpl implements SubstanciaDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Substancia, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	SubstanciaDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Substancia, Long>(Substancia.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(Substancia substancia) {
		genericoDao.inserir(substancia);
	}

	@Override
	public void remover(Substancia substancia) {
		genericoDao.remover(substancia);		
	}

	@Override
	public void atualizar(Substancia substancia) {
		genericoDao.atualizar(substancia);		
	}
	
	@Override
	public Substancia pesquisarPorId(Long cdSubstancia){
		return genericoDao.pesquisarPorID(cdSubstancia);
	}

	@Override
	public List<Substancia> listarSubstancias() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<Substancia> pesquisarSubstancias(SubstanciaFiltro substanciaFiltro) {
		return entityManager.createQuery("from Substancia where upper(dsSubstancia) like :dsSubstancia",Substancia.class).
				setParameter("dsSubstancia", "%" + substanciaFiltro.getDsSubstancia().toUpperCase() + "%").
				getResultList();
	}
}
