package br.gov.pe.sismepe.ehospenterprise.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pe.sismepe.ehospenterprise.dao.CidDao;
import br.gov.pe.sismepe.ehospenterprise.dao.GenericoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cid;
import br.gov.pe.sismepe.ehospenterprise.filtro.CidFiltro;

public class CidDaoImpl implements CidDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Cid, Long> genericoDao;
	private EntityManager entityManager;
	
	@Inject
	CidDaoImpl(EntityManager entityManager){
		genericoDao = new GenericoDaoImpl<Cid, Long>(Cid.class, entityManager);
		this.entityManager = entityManager;
	}
	
	@Override
	public void inserir(Cid cid) {
		genericoDao.inserir(cid);
	}

	@Override
	public void remover(Cid cid) {
		genericoDao.remover(cid);		
	}

	@Override
	public void atualizar(Cid cid) {
		genericoDao.atualizar(cid);		
	}
	
	@Override
	public Cid pesquisarPorId(Long cdCid){
		return genericoDao.pesquisarPorID(cdCid);
	}
	
	@Override
	public List<Cid> listarCids() {
		return genericoDao.listarTodos();
	}

	@Override
	public List<Cid> pesquisarCids(CidFiltro cidFiltro) {
		List<Cid> listaCid = null;
		
		if (cidFiltro.getCdCid() != null) {
			// id deve ser maior ou igual (ge = greater or equals) a filtro.numeroDe
			listaCid = entityManager.createQuery("from Cid where cdCid = :cdCid",Cid.class).
					setParameter("cdCid", cidFiltro.getCdCid()).
					getResultList();
		}
		else if (cidFiltro.getDsCid() != null) {
			listaCid = entityManager.createQuery("from Cid where upper(dsCid) like :dsCid",Cid.class).
					setParameter("dsCid", "%" + cidFiltro.getDsCid().toUpperCase() + "%").
					getResultList();
		}
		
		return listaCid;
	}
}
