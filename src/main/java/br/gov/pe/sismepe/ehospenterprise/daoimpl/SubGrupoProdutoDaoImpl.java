package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.SubGrupoProdutoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.SubGrupoProduto;
import br.gov.pe.sismepe.ehospenterprise.filtro.SubGrupoProdutoFiltro;

public class SubGrupoProdutoDaoImpl implements SubGrupoProdutoDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<SubGrupoProduto, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	SubGrupoProdutoDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<SubGrupoProduto, Long>(SubGrupoProduto.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(SubGrupoProduto subGrupoProduto) {
		genericoDao.inserir(subGrupoProduto);
	}

	@Override
	public void remover(SubGrupoProduto subGrupoProduto) {
		genericoDao.remover(subGrupoProduto);		
	}

	@Override
	public void atualizar(SubGrupoProduto subGrupoProduto) {
		genericoDao.atualizar(subGrupoProduto);		
	}
	
	@Override
	public SubGrupoProduto pesquisarPorId(Long cdSubGrupoProduto){
		return genericoDao.pesquisarPorID(cdSubGrupoProduto);
	}

	@Override
	public List<SubGrupoProduto> listarSubGrupoProdutos() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<SubGrupoProduto> pesquisarSubGrupoProdutos(SubGrupoProdutoFiltro subGrupoProdutoFiltro) {
		return entityManager.createQuery("from SubGrupoProduto where upper(dsSubGrupoProduto) like :dsSubGrupoProduto",SubGrupoProduto.class).
				setParameter("dsSubGrupoProduto", "%" + subGrupoProdutoFiltro.getDsSubGrupoProduto().toUpperCase() + "%").
				getResultList();
	}
}
