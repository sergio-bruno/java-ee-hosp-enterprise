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

import br.gov.pe.sismepe.ehospenterprise.dao.TipoConselhoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.TipoConselho;
import br.gov.pe.sismepe.ehospenterprise.filtro.TipoConselhoFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.sessao.SessionContext;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class TipoConselhoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	TipoConselhoDao tipoConselhoDao;
	private TipoConselho tipoConselho = new TipoConselho();
	private List<TipoConselho> tipoConselhos;
	
	private TipoConselhoFiltro tipoConselhoFiltro;
	
	public TipoConselhoBean() {
		tipoConselhoFiltro = new TipoConselhoFiltro();
		tipoConselhos = null;
	}
	
	public TipoConselhoFiltro getTipoConselhoFiltro() {
		return tipoConselhoFiltro;
	}

	@Transacional
	public void salvar(){
		
		System.out.print("Tipo conselho->setor: "+SessionContext.getInstance().getAttribute("setor")+"\n");
		
		if(tipoConselho.getDsTipoConselho() == null || tipoConselho.getDsTipoConselho().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição do tipo de conselho é obrigatória!");
		} else if(tipoConselho.getSnAtivo() == null || tipoConselho.getSnAtivo().equals("")){
				MensagemUtil.addMensagemDeAviso("Atenção", "É necessário informar se este tipo de conselho encontra-se ativo!");
		} else {
			if(tipoConselho.getCdTipoConselho() == null){
				tipoConselhoDao.inserir(tipoConselho);
			}else{
				tipoConselhoDao.atualizar(tipoConselho);
			}
			tipoConselho = new TipoConselho();
			tipoConselhos = tipoConselhoDao.listarTipoConselhos();
			MensagemUtil.addMensagemInformativa("Informação", "Tipo de conselho gravado com sucesso!");
		}
	}

	@Transacional
	public void remover(TipoConselho tipoConselho){
		tipoConselhoDao.remover(tipoConselho);
		tipoConselhos = tipoConselhoDao.listarTipoConselhos();
		MensagemUtil.addMensagemInformativa("Informação", "Tipo de conselho excluído com sucesso!");
	}
	
	public List<TipoConselho> getTipoConselhos(){
		if(tipoConselhos == null){
			tipoConselhos = tipoConselhoDao.listarTipoConselhos();
		}
		return tipoConselhos;
	}

	public List<TipoConselho> pesquisaTipoConselhos() {
		tipoConselhos = tipoConselhoDao.pesquisarTipoConselhos(tipoConselhoFiltro);
		return tipoConselhos;
	}

	public TipoConselho getTipoConselho() {
	   if (tipoConselho == null){  
		   tipoConselho = new TipoConselho();  
	    }  
	    return tipoConselho;		
	}

	public void setTipoConselho(TipoConselho tipoConselho) {
		this.tipoConselho = tipoConselho;
	}
}
