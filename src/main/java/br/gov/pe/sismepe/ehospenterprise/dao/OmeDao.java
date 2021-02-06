package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Ome;
import br.gov.pe.sismepe.ehospenterprise.filtro.OmeFiltro;

public interface OmeDao {
	void inserir(Ome ome);

	void remover(Ome ome);

	void atualizar(Ome ome);

	Ome pesquisarPorId(Long cdOme);
	
	List<Ome> listarOmes();
	
	List<Ome> pesquisarOmes(OmeFiltro omeFiltro);
}
