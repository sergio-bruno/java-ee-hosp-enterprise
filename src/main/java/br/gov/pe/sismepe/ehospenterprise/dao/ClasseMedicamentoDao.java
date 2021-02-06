package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.ClasseMedicamento;
import br.gov.pe.sismepe.ehospenterprise.filtro.ClasseMedicamentoFiltro;

public interface ClasseMedicamentoDao {
	void inserir(ClasseMedicamento classeMedicamento);

	void remover(ClasseMedicamento classeMedicamento);

	void atualizar(ClasseMedicamento classeMedicamento);

	ClasseMedicamento pesquisarPorId(Long cdClasseMedicamento);
	
	List<ClasseMedicamento> listarClasseMedicamentos();
	
	List<ClasseMedicamento> pesquisarClasseMedicamentos(ClasseMedicamentoFiltro classeMedicamentoFiltro);
}
