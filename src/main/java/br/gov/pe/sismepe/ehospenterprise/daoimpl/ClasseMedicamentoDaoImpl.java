package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.ClasseMedicamentoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.ClasseMedicamento;
import br.gov.pe.sismepe.ehospenterprise.filtro.ClasseMedicamentoFiltro;

public class ClasseMedicamentoDaoImpl implements ClasseMedicamentoDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<ClasseMedicamento, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	ClasseMedicamentoDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<ClasseMedicamento, Long>(ClasseMedicamento.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(ClasseMedicamento classeMedicamento) {
		genericoDao.inserir(classeMedicamento);
	}

	@Override
	public void remover(ClasseMedicamento classeMedicamento) {
		genericoDao.remover(classeMedicamento);		
	}

	@Override
	public void atualizar(ClasseMedicamento classeMedicamento) {
		genericoDao.atualizar(classeMedicamento);		
	}
	
	@Override
	public ClasseMedicamento pesquisarPorId(Long cdClasseMedicamento){
		return genericoDao.pesquisarPorID(cdClasseMedicamento);
	}

	@Override
	public List<ClasseMedicamento> listarClasseMedicamentos() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<ClasseMedicamento> pesquisarClasseMedicamentos(ClasseMedicamentoFiltro classeMedicamentoFiltro) {
		return entityManager.createQuery("from ClasseMedicamento where upper(dsClasseMedicamento) like :dsClasseMedicamento",ClasseMedicamento.class).
				setParameter("dsClasseMedicamento", "%" + classeMedicamentoFiltro.getDsClasseMedicamento().toUpperCase() + "%").
				getResultList();
	}
}
