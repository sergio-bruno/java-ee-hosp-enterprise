/**
 * Classe omeBean.java
 * Classe principal de bean para o ome, usada para comunicação com o front-end
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

import br.gov.pe.sismepe.ehospenterprise.dao.OmeDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Ome;
import br.gov.pe.sismepe.ehospenterprise.filtro.OmeFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class OmeBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	OmeDao omeDao;
	private Ome ome = new Ome();
	private List<Ome> omes;
	
	private OmeFiltro omeFiltro;
	
	public OmeBean() {
		omeFiltro = new OmeFiltro();
		ome = new Ome();
		omes = null;
	}
	
	public OmeFiltro getOmeFiltro() {
		return omeFiltro;
	}

	@Transacional
	public void salvar(){
		if(ome.getCdOme() == null || ome.getCdOme().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "O código da OME é obrigatória!");
		} else if(ome.getDsOme() == null || ome.getDsOme().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição da OME é obrigatória!");
		} else {
			Ome existeOme = null;
			existeOme = omeDao.pesquisarPorId(ome.getCdOme());
			
			if(existeOme == null){
				omeDao.inserir(ome);
			}else{
				omeDao.atualizar(ome);
			}
			ome = new Ome();
			omes = omeDao.listarOmes();
			MensagemUtil.addMensagemInformativa("Informação","OME gravada com sucesso!");
		}
	}

	@Transacional
	public void remover(Ome ome){
		omeDao.remover(ome);
		omes = omeDao.listarOmes();
		MensagemUtil.addMensagemInformativa("Informação","OME excluída com sucesso!");
	}
	
	public List<Ome> getOmes(){
		if(omes == null){
			omes = omeDao.listarOmes();
		}
		return omes;
	}

	public List<Ome> pesquisaOmes() {
		omes = omeDao.pesquisarOmes(omeFiltro);
		return omes;
	}

	public Ome getOme() {
	   if (ome == null){  
		   ome = new Ome();  
	    }  
	    return ome;
	}

	public void setOme(Ome ome) {
		this.ome = ome;
	}
}
