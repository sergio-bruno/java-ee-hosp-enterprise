package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.GrupoProdutoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.GrupoProduto;
import br.gov.pe.sismepe.ehospenterprise.filtro.GrupoProdutoFiltro;

public class GrupoProdutoDaoImpl implements GrupoProdutoDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<GrupoProduto, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	GrupoProdutoDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<GrupoProduto, Long>(GrupoProduto.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(GrupoProduto grupoProduto) {
		genericoDao.inserir(grupoProduto);
	}

	@Override
	public void remover(GrupoProduto grupoProduto) {
		genericoDao.remover(grupoProduto);		
	}

	@Override
	public void atualizar(GrupoProduto grupoProduto) {
		genericoDao.atualizar(grupoProduto);		
	}
	
	@Override
	public GrupoProduto pesquisarPorId(Long cdGrupoProduto){
		return genericoDao.pesquisarPorID(cdGrupoProduto);
	}

	@Override
	public List<GrupoProduto> listarGrupoProdutos() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<GrupoProduto> pesquisarGrupoProdutos(GrupoProdutoFiltro grupoProdutoFiltro) {
		return entityManager.createQuery("from GrupoProduto where upper(dsGrupoProduto) like :dsGrupoProduto",GrupoProduto.class).
				setParameter("dsGrupoProduto", "%" + grupoProdutoFiltro.getDsGrupoProduto().toUpperCase() + "%").
				getResultList();
	}
}
