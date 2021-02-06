package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.TipoConselho;
import br.gov.pe.sismepe.ehospenterprise.filtro.TipoConselhoFiltro;

public interface TipoConselhoDao {
	void inserir(TipoConselho tipoConselho);

	void remover(TipoConselho tipoConselho);

	void atualizar(TipoConselho tipoConselho);

	TipoConselho pesquisarPorId(Long cdTipoConselho);
	
	List<TipoConselho> listarTipoConselhos();
	
	List<TipoConselho> pesquisarTipoConselhos(TipoConselhoFiltro tipoConselhoFiltro);
}
