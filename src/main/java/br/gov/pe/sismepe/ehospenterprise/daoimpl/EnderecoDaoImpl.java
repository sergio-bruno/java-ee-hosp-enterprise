package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.EnderecoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Endereco;
import br.gov.pe.sismepe.ehospenterprise.filtro.EnderecoFiltro;

public class EnderecoDaoImpl implements EnderecoDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Endereco, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	EnderecoDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Endereco, Long>(Endereco.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(Endereco endereco) {
		genericoDao.inserir(endereco);
	}

	@Override
	public void remover(Endereco endereco) {
		genericoDao.remover(endereco);		
	}

	@Override
	public void atualizar(Endereco endereco) {
		genericoDao.atualizar(endereco);		
	}
	
	@Override
	public Endereco pesquisarPorId(Long cdEndereco){
		return genericoDao.pesquisarPorID(cdEndereco);
	}

	@Override
	public List<Endereco> listarEnderecos() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<Endereco> pesquisarEnderecos(EnderecoFiltro enderecoFiltro) {
		return entityManager.createQuery("from Endereco where upper(dsEndereco) like :dsEndereco",Endereco.class).
				setParameter("dsEndereco", "%" + enderecoFiltro.getDsEndereco().toUpperCase() + "%").
				getResultList();
	}
}
