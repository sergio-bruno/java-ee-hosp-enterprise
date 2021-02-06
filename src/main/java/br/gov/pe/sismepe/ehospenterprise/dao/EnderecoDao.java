package br.gov.pe.sismepe.ehospenterprise.dao;

import java.util.List;

import br.gov.pe.sismepe.ehospenterprise.entidades.Endereco;
import br.gov.pe.sismepe.ehospenterprise.filtro.EnderecoFiltro;

public interface EnderecoDao {
	void inserir(Endereco endereco);

	void remover(Endereco endereco);

	void atualizar(Endereco endereco);

	Endereco pesquisarPorId(Long cdEndereco);
	
	List<Endereco> listarEnderecos();
	
	List<Endereco> pesquisarEnderecos(EnderecoFiltro enderecoFiltro);
}
