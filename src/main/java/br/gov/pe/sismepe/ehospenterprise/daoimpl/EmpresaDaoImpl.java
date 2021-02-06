package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.EmpresaDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Empresa;
import br.gov.pe.sismepe.ehospenterprise.filtro.EmpresaFiltro;

public class EmpresaDaoImpl implements EmpresaDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Empresa, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	EmpresaDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Empresa, Long>(Empresa.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(Empresa empresa) {
		genericoDao.inserir(empresa);
	}

	@Override
	public void remover(Empresa empresa) {
		genericoDao.remover(empresa);		
	}

	@Override
	public void atualizar(Empresa empresa) {
		genericoDao.atualizar(empresa);		
	}
	
	@Override
	public Empresa pesquisarPorId(Long cdEmpresa){
		return genericoDao.pesquisarPorID(cdEmpresa);
	}

	@Override
	public List<Empresa> listarEmpresas() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<Empresa> pesquisarEmpresas(EmpresaFiltro empresaFiltro) {
		return entityManager.createQuery("from Empresa where upper(nmRazaoSocial) like :nmRazaoSocial",Empresa.class).
				setParameter("nmRazaoSocial", "%" + empresaFiltro.getNmRazaoSocial().toUpperCase() + "%").
				getResultList();
	}
}
