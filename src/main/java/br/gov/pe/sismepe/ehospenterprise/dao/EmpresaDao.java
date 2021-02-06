package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Empresa;
import br.gov.pe.sismepe.ehospenterprise.filtro.EmpresaFiltro;

public interface EmpresaDao {
	void inserir(Empresa empresa);

	void remover(Empresa empresa);

	void atualizar(Empresa empresa);

	Empresa pesquisarPorId(Long cdEmpresa);
	
	List<Empresa> listarEmpresas();
	
	List<Empresa> pesquisarEmpresas(EmpresaFiltro empresaFiltro);
}
