package br.gov.pe.sismepe.ehospenterprise.security;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.gov.pe.sismepe.ehospenterprise.sessao.SessionContext;

@Named
@RequestScoped
public class Seguranca {

	public String getNomeUsuario() {
		String nome = getUsuarioLogado();
		return nome;
	}

	@Produces
	@UsuarioLogado
	public String getUsuarioLogado() {
		String usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (auth != null && auth.getPrincipal() != null) {
			usuario = auth.getPrincipal().toString();
		}
		
		SessionContext.getInstance().setAttribute("setor", "APROVISIONAMENTO DO CASIS");
		
		return usuario;
	}
	
}