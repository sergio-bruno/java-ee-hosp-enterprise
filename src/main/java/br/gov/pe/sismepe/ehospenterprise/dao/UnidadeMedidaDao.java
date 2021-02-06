package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.UnidadeMedida;
import br.gov.pe.sismepe.ehospenterprise.filtro.UnidadeMedidaFiltro;

public interface UnidadeMedidaDao {
	void inserir(UnidadeMedida unidadeMedida);

	void remover(UnidadeMedida unidadeMedida);

	void atualizar(UnidadeMedida unidadeMedida);

	UnidadeMedida pesquisarPorId(Long cdUnidadeMedida);
	
	List<UnidadeMedida> listarUnidadeMedidas();
	
	List<UnidadeMedida> pesquisarUnidadeMedidas(UnidadeMedidaFiltro unidadeMedidaFiltro);
}
