/**
 * Classe TipoConselhoBean.java
 * Classe principal de bean para o tipo de conselho, usada para comunicação com o front-end
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.pe.sismepe.ehospenterprise.dao.UfDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Uf;

@Named
@ViewScoped
public class UfBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	UfDao ufDao;
	private List<Uf> ufs;
	
	public UfBean() {
		ufs = null;
	}
	
	public List<Uf> getUfs(){
		if(ufs == null){
			ufs = ufDao.listarUfs();
		}
		return ufs;
	}

}
