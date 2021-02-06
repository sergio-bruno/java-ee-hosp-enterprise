/**
 * Classe SessionListener.java
 * Classe usada para monitorar esse ciclo de vida da nossa Sess�o.
 * Esta classe tem a finalidade de mostrar o �nicio e fim de uma sess�o do usu�rio
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.sessao;

import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
public class SessionListener implements HttpSessionListener {
    
 
    public void sessionCreated(HttpSessionEvent event) {        
    	String entradaAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(event.getSession().getLastAccessedTime()));
    	System.out.println("Sess�o criada " + event.getSession().getId()+". Acesso em = "+entradaAcesso);
    }
 
    public void sessionDestroyed(HttpSessionEvent event) {     
         String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(event.getSession().getLastAccessedTime()));
         System.out.println("Sess�o expirada "+event.getSession().getId()+". Ultimo Acesso = "+ultimoAcesso);
    }
 
}