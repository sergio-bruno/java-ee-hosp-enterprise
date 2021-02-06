package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Cidade;

public interface CidadeDao {
	
	Cidade pesquisarPorId(Long cdCidade);
	
	List<Cidade> listarCidades();
	
	List<Cidade> pesquisarCidades(String cidadeFiltro);
}
