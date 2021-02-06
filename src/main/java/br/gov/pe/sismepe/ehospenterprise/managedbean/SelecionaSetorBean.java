/**
 * Classe SelecionaSetorBean.java
 * Classe principal de bean para sele��o de setor de trabalho do usu�rio
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.managedbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.gov.pe.sismepe.ehospenterprise.sessao.SessionContext;

@Named
@RequestScoped
public class SelecionaSetorBean {

	private String dsSetor;

	public String getDsSetor() {
		return dsSetor;
	}

	public void setDsSetor(String dsSetor) {
		System.out.print("setor selecionado set: "+dsSetor+"\n");
		this.dsSetor = dsSetor;
	}
	
	public void selecionarSetor() {
		SessionContext.getInstance().setAttribute("sessionNomeSetor", this.dsSetor);
		System.out.print("setor selecionado session: "+SessionContext.getInstance().getAttribute("sessionNomeSetor")+"\n");
	}
	
}
