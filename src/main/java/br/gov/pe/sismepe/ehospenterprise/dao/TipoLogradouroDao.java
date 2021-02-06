package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.TipoLogradouro;

public interface TipoLogradouroDao {
	
	TipoLogradouro pesquisarPorId(Long cdTipoLogradouro);
	
	List<TipoLogradouro> listarTipoLogradouros();
	
	List<TipoLogradouro> pesquisarTipoLogradouros(String logradouroFiltro);
}
