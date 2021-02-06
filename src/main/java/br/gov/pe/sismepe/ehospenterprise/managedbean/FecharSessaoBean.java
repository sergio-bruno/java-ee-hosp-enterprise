/**
 * Classe FecharSessaoBean.java
 * Classe principal para encerrar a sessão do usuário no navegador
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.managedbean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Named
@RequestScoped
public class FecharSessaoBean {

	public String encerraSessao() {  
        //SessionContext.getInstance().encerrarSessao();
        String navegacao = "";  
          
        try {  
            deslogar();  
            navegacao = "logout";  
        } catch(Exception e) {  
              
        }  
          
        return navegacao;  
    }	
	
	public void deslogar() {  
        
        SecurityContext sc = SecurityContextHolder.getContext();  
        Authentication authentication = sc.getAuthentication();  
                                                  
            final HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  
              
            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();      
            logoutHandler.setInvalidateHttpSession(true);  
            logoutHandler.logout(request, null, authentication);                  
    }	
}
