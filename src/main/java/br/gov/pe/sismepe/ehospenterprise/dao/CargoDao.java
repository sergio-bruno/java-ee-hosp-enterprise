package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Cargo;
import br.gov.pe.sismepe.ehospenterprise.filtro.CargoFiltro;

public interface CargoDao {
	void inserir(Cargo cargo);

	void remover(Cargo cargo);

	void atualizar(Cargo cargo);

	Cargo pesquisarPorId(Long cdCargo);
	
	List<Cargo> listarCargos();
	
	List<Cargo> pesquisarCargos(CargoFiltro cargoFiltro);
}
