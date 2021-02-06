package br.gov.pe.sismepe.ehospenterprise.security.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.gov.pe.sismepe.ehospenterprise.dao.UsuarioDAO;
import br.gov.pe.sismepe.ehospenterprise.domain.Usuario;
 
@Named
public class UsuarioService implements UserDetailsService {
 
	@Inject
	private UsuarioDAO usuarioDAO;
 
    @Override
    public Usuario loadUserByUsername(final String login) throws UsernameNotFoundException {
    	return usuarioDAO.retornaUsuarioPeloLogin(login);
    }

}