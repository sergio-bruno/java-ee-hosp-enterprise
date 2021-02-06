package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Conselho;
import br.gov.pe.sismepe.ehospenterprise.filtro.ConselhoFiltro;

public interface ConselhoDao {
	void inserir(Conselho conselho);

	void remover(Conselho conselho);

	void atualizar(Conselho conselho);

	Conselho pesquisarPorId(Long cdConselho);
	
	List<Conselho> listarConselhos();
	
	List<Conselho> pesquisarConselhos(ConselhoFiltro conselhoFiltro);
}
