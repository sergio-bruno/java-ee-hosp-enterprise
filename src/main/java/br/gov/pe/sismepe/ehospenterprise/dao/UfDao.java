package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Uf;

public interface UfDao {
	
	Uf pesquisarPorId(String cdUf);
	
	List<Uf> listarUfs();
	
	List<Uf> pesquisarUfs(String ufFiltro);
}
