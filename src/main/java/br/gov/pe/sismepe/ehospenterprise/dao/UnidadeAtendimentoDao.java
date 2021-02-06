package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.UnidadeAtendimento;
import br.gov.pe.sismepe.ehospenterprise.filtro.UnidadeAtendimentoFiltro;

public interface UnidadeAtendimentoDao {
	void inserir(UnidadeAtendimento unidadeAtendimento);

	void remover(UnidadeAtendimento unidadeAtendimento);

	void atualizar(UnidadeAtendimento unidadeAtendimento);

	UnidadeAtendimento pesquisarPorId(Long cdUnidadeAtendimento);
	
	List<UnidadeAtendimento> listarUnidadeAtendimentos();
	
	List<UnidadeAtendimento> pesquisarUnidadeAtendimentos(UnidadeAtendimentoFiltro unidadeAtendimentoFiltro);
}
