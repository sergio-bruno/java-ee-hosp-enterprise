package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Substancia;
import br.gov.pe.sismepe.ehospenterprise.filtro.SubstanciaFiltro;

public interface SubstanciaDao {
	void inserir(Substancia substancia);

	void remover(Substancia substancia);

	void atualizar(Substancia substancia);

	Substancia pesquisarPorId(Long cdSubstancia);
	
	List<Substancia> listarSubstancias();
	
	List<Substancia> pesquisarSubstancias(SubstanciaFiltro substanciaFiltro);
}
