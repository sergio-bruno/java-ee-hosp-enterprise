/**
 * Classe SessionContext.java
 * Classe usada para controle de sessão do usuário.
 * Esta classe trabalha com o padrão de projeto Singleton, assim
 * existe a garantia que só existirá uma instância deste objeto 
 * durante toda o ciclo de vida da aplicação
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.sessao;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
 
public class SessionContext {
    
    private static SessionContext instance;
    
    public static SessionContext getInstance(){
       if (instance == null){
           instance = new SessionContext();
       }
       
       return instance;
    }
    
    private SessionContext(){
       
    }
    
    private ExternalContext currentExternalContext(){
       if (FacesContext.getCurrentInstance() == null){
           throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
       }else{
           return FacesContext.getCurrentInstance().getExternalContext();
       }
    }
    
    
    public void encerrarSessao(){
       currentExternalContext().invalidateSession();
    }
    
    public Object getAttribute(String nome){
       return currentExternalContext().getSessionMap().get(nome);
    }
    
    public void setAttribute(String nome, Object valor){
       currentExternalContext().getSessionMap().put(nome, valor);
    }
    
}