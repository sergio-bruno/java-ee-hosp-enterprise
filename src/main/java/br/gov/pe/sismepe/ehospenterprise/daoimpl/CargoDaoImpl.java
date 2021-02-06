package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.CargoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cargo;
import br.gov.pe.sismepe.ehospenterprise.filtro.CargoFiltro;

public class CargoDaoImpl implements CargoDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Cargo, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	CargoDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Cargo, Long>(Cargo.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(Cargo cargo) {
		genericoDao.inserir(cargo);
	}

	@Override
	public void remover(Cargo cargo) {
		genericoDao.remover(cargo);		
	}

	@Override
	public void atualizar(Cargo cargo) {
		genericoDao.atualizar(cargo);		
	}
	
	@Override
	public Cargo pesquisarPorId(Long cdCargo){
		return genericoDao.pesquisarPorID(cdCargo);
	}

	@Override
	public List<Cargo> listarCargos() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<Cargo> pesquisarCargos(CargoFiltro cargoFiltro) {
		return entityManager.createQuery("from Cargo where upper(dsCargo) like :dsCargo",Cargo.class).
				setParameter("dsCargo", "%" + cargoFiltro.getDsCargo().toUpperCase() + "%").
				getResultList();
	}
}
