package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.SubGrupoProduto;
import br.gov.pe.sismepe.ehospenterprise.filtro.SubGrupoProdutoFiltro;

public interface SubGrupoProdutoDao {
	void inserir(SubGrupoProduto subGrupoProduto);

	void remover(SubGrupoProduto subGrupoProduto);

	void atualizar(SubGrupoProduto subGrupoProduto);

	SubGrupoProduto pesquisarPorId(Long cdSubGrupoProduto);
	
	List<SubGrupoProduto> listarSubGrupoProdutos();
	
	List<SubGrupoProduto> pesquisarSubGrupoProdutos(SubGrupoProdutoFiltro subGrupoProdutoFiltro);
}
