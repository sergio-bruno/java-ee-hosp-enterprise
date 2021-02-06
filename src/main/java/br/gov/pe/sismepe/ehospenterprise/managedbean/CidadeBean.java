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

import br.gov.pe.sismepe.ehospenterprise.dao.CidadeDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cidade;

@Named
@ViewScoped
public class CidadeBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	CidadeDao cidadeDao;
	private List<Cidade> cidades;
	
	public CidadeBean() {
		cidades = null;
	}
	
	public List<Cidade> getCidades(){
		if(cidades == null){
			cidades = cidadeDao.listarCidades();
		}
		return cidades;
	}

}
