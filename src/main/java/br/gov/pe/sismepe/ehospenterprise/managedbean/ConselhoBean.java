/**
 * Classe ConselhoBean.java
 * Classe principal de bean para o conselho, usada para comunicação com o front-end
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

import br.gov.pe.sismepe.ehospenterprise.dao.ConselhoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.TipoConselhoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Conselho;
import br.gov.pe.sismepe.ehospenterprise.entidades.TipoConselho;
import br.gov.pe.sismepe.ehospenterprise.filtro.ConselhoFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class ConselhoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	ConselhoDao conselhoDao;
	private Conselho conselho = new Conselho();
	private List<Conselho> conselhos;
	private ConselhoFiltro conselhoFiltro;

	@Inject
	private TipoConselhoDao tipoConselhoDao;
	private Long cdTipoConselho;
	
	public ConselhoBean() {
		conselhoFiltro = new ConselhoFiltro();
		conselhos = null;
	}
	
	public ConselhoFiltro getConselhoFiltro() {
		return conselhoFiltro;
	}

	@Transacional
	public void salvar(){
		if(conselho.getDsConselho() == null || conselho.getDsConselho().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição do conselho é obrigatória!");
		} else if(conselho.getSnAtivo() == null || conselho.getSnAtivo().equals("")){
				MensagemUtil.addMensagemDeAviso("Atenção", "É necessário informar se este conselho encontra-se ativo!");
		} else if(conselho.getDsSigla() == null || conselho.getDsSigla().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "É necessário informar a sigla do conselho!");
		} else if(conselho.getCdUf() == null || conselho.getCdUf().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "É necessário informar a UF do conselho!");
		} else {
			TipoConselho tipoConselho = tipoConselhoDao.pesquisarPorId(cdTipoConselho);
			conselho.setTipoConselho(tipoConselho);
			
			if(conselho.getCdConselho() == null){
				conselhoDao.inserir(conselho);
			}else{
				conselhoDao.atualizar(conselho);
			}
			conselho = new Conselho();
			conselhos = conselhoDao.listarConselhos();
			cdTipoConselho = null;
			MensagemUtil.addMensagemInformativa("Informação", "Tipo de conselho gravado com sucesso!");
		}
	}

	public void alterar(Conselho conselho){
		this.conselho = conselho;
		cdTipoConselho = conselho.getTipoConselho().getCdTipoConselho();
	}
	
	public Long getCdTipoConselho() {
		return cdTipoConselho;
	}

	public void setCdTipoConselho(Long cdTipoConselho) {
		this.cdTipoConselho = cdTipoConselho;
	}

	@Transacional
	public void remover(Conselho conselho){
		conselhoDao.remover(conselho);
		conselhos = conselhoDao.listarConselhos();
		MensagemUtil.addMensagemInformativa("Informação", "Tipo de conselho excluído com sucesso!");
	}
	
	public List<Conselho> getConselhos(){
		if(conselhos == null){
			conselhos = conselhoDao.listarConselhos();
		}
		return conselhos;
	}

	public List<Conselho> pesquisaConselhos() {
		conselhos = conselhoDao.pesquisarConselhos(conselhoFiltro);
		return conselhos;
	}

	public Conselho getConselho() {
	   if (conselho == null){  
		   conselho = new Conselho();  
	    }  
	    return conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}
}
