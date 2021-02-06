/**
 * Classe SessionContext.java
 * Classe usada para controle de sess�o do usu�rio.
 * Esta classe trabalha com o padr�o de projeto Singleton, assim
 * existe a garantia que s� existir� uma inst�ncia deste objeto 
 * durante toda o ciclo de vida da aplica��o
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
           throw new RuntimeException("O FacesContext n�o pode ser chamado fora de uma requisi��o HTTP");
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