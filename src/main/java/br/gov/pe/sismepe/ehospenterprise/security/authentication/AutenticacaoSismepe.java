package br.gov.pe.sismepe.ehospenterprise.security.authentication;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import br.gov.pe.sismepe.ehospenterprise.domain.Usuario;
import br.gov.pe.sismepe.ehospenterprise.security.service.UsuarioService;
import br.gov.pe.sismepe.ehospenterprise.util.HashPassword;
 
@Named
public class AutenticacaoSismepe implements AuthenticationProvider {
	
	@Inject
    private UsuarioService usuarioService; 
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException  {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        Usuario usuario = usuarioService.loadUserByUsername(username);
        if(usuario.getUsername() == null)
        	 throw new BadCredentialsException("Login ou usuário inválidos!");
        
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (usuario == null || !encoder.matches(password, usuario.getPassword())) {
        
        try {
			if (! HashPassword.md5(password).equals(usuario.getPassword()) ) {
			   throw new BadCredentialsException("Login ou usuário inválidos!");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        
        Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    public boolean supports(Class<?> arg0) {
        return true;
    }
    
    
    
}