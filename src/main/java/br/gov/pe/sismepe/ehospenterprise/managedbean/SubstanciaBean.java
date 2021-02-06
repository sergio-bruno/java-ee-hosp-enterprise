/**
 * Classe substanciaBean.java
 * Classe principal de bean para o substancia, usada para comunicação com o front-end
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

import br.gov.pe.sismepe.ehospenterprise.dao.SubstanciaDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Substancia;
import br.gov.pe.sismepe.ehospenterprise.filtro.SubstanciaFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class SubstanciaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	SubstanciaDao substanciaDao;
	private Substancia substancia = new Substancia();
	private List<Substancia> substancias;
	
	private SubstanciaFiltro substanciaFiltro;
	
	public SubstanciaBean() {
		substanciaFiltro = new SubstanciaFiltro();
		substancia = new Substancia();
		substancias = null;
	}
	
	public SubstanciaFiltro getSubstanciaFiltro() {
		return substanciaFiltro;
	}

	@Transacional
	public void salvar(){
		if(substancia.getDsSubstancia() == null || substancia.getDsSubstancia().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição do substancia é obrigatória!");
		} else {
			if(substancia.getCdSubstancia() == null){
				substanciaDao.inserir(substancia);
			}else{
				substanciaDao.atualizar(substancia);
			}
			substancia = new Substancia();
			substancias = substanciaDao.listarSubstancias();
			MensagemUtil.addMensagemInformativa("Informação","Substancia gravado com sucesso!");
		}
	}

	@Transacional
	public void remover(Substancia substancia){
		substanciaDao.remover(substancia);
		substancias = substanciaDao.listarSubstancias();
		MensagemUtil.addMensagemInformativa("Informação","Substancia excluído com sucesso!");
	}
	
	public List<Substancia> getSubstancias(){
		if(substancias == null){
			substancias = substanciaDao.listarSubstancias();
		}
		return substancias;
	}

	public List<Substancia> pesquisaSubstancias() {
		substancias = substanciaDao.pesquisarSubstancias(substanciaFiltro);
		return substancias;
	}

	public Substancia getSubstancia() {
	   if (substancia == null){  
		   substancia = new Substancia();  
	    }  
	    return substancia;
	}

	public void setSubstancia(Substancia substancia) {
		this.substancia = substancia;
	}
}
