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

import br.gov.pe.sismepe.ehospenterprise.dao.TipoLogradouroDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.TipoLogradouro;

@Named
@ViewScoped
public class TipoLogradouroBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	TipoLogradouroDao tipoLogradouroDao;
	private List<TipoLogradouro> tipoLogradouros;
	
	public TipoLogradouroBean() {
		tipoLogradouros = null;
	}
	
	public List<TipoLogradouro> getTipoLogradouros(){
		if(tipoLogradouros == null){
			tipoLogradouros = tipoLogradouroDao.listarTipoLogradouros();
		}
		return tipoLogradouros;
	}

}
