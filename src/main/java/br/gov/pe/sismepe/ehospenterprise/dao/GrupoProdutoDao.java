package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.GrupoProduto;
import br.gov.pe.sismepe.ehospenterprise.filtro.GrupoProdutoFiltro;

public interface GrupoProdutoDao {
	void inserir(GrupoProduto grupoProduto);

	void remover(GrupoProduto grupoProduto);

	void atualizar(GrupoProduto grupoProduto);

	GrupoProduto pesquisarPorId(Long cdGrupoProduto);
	
	List<GrupoProduto> listarGrupoProdutos();
	
	List<GrupoProduto> pesquisarGrupoProdutos(GrupoProdutoFiltro grupoProdutoFiltro);
}
