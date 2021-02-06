package br.gov.pe.sismepe.ehospenterprise.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.gov.pe.sismepe.ehospenterprise.domain.Usuario;

@Named
public class UsuarioDAO {

	private EntityManager entityManager;
	
	private UsuarioDAO() {
		criaEntityManager();
	}

	private void criaEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sismepePU");
		entityManager = emf.createEntityManager();
	}

	public Usuario retornaUsuarioPeloLogin(String login) {
		Usuario usuario = new Usuario();
		Query query = entityManager.createQuery("from Usuario u where u.username = :login");
		try {
			query.setParameter("login", login);
			usuario = (Usuario) query.getSingleResult();
		} catch (NoResultException e) { 
		}
		return usuario;
	}
}
