package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Cid;
import br.gov.pe.sismepe.ehospenterprise.filtro.CidFiltro;

public interface CidDao {
	void inserir(Cid cid);

	void remover(Cid cid);

	void atualizar(Cid cid);

	Cid pesquisarPorId(Long cdCid);
	
	List<Cid> listarCids();
	
	List<Cid> pesquisarCids(CidFiltro cidFiltro);
}
