package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.UnidadeAtendimentoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.UnidadeAtendimento;
import br.gov.pe.sismepe.ehospenterprise.filtro.UnidadeAtendimentoFiltro;

public class UnidadeAtendimentoDaoImpl implements UnidadeAtendimentoDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<UnidadeAtendimento, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	UnidadeAtendimentoDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<UnidadeAtendimento, Long>(UnidadeAtendimento.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(UnidadeAtendimento unidadeAtendimento) {
		genericoDao.inserir(unidadeAtendimento);
	}

	@Override
	public void remover(UnidadeAtendimento unidadeAtendimento) {
		genericoDao.remover(unidadeAtendimento);		
	}

	@Override
	public void atualizar(UnidadeAtendimento unidadeAtendimento) {
		genericoDao.atualizar(unidadeAtendimento);		
	}
	
	@Override
	public UnidadeAtendimento pesquisarPorId(Long cdUnidadeAtendimento){
		return genericoDao.pesquisarPorID(cdUnidadeAtendimento);
	}

	@Override
	public List<UnidadeAtendimento> listarUnidadeAtendimentos() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<UnidadeAtendimento> pesquisarUnidadeAtendimentos(UnidadeAtendimentoFiltro unidadeAtendimentoFiltro) {
		return entityManager.createQuery("from UnidadeAtendimento where upper(dsUnidadeAtendimento) like :dsUnidadeAtendimento",UnidadeAtendimento.class).
				setParameter("dsUnidadeAtendimento", "%" + unidadeAtendimentoFiltro.getDsUnidadeAtendimento().toUpperCase() + "%").
				getResultList();
	}
}
