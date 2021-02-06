/**
 * Classe subGrupoProdutoBean.java
 * Classe principal de bean para o subGrupoProduto, usada para comunicação com o front-end
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

import br.gov.pe.sismepe.ehospenterprise.dao.GrupoProdutoDao;
import br.gov.pe.sismepe.ehospenterprise.dao.SubGrupoProdutoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.GrupoProduto;
import br.gov.pe.sismepe.ehospenterprise.entidades.SubGrupoProduto;
import br.gov.pe.sismepe.ehospenterprise.filtro.SubGrupoProdutoFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class SubGrupoProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	SubGrupoProdutoDao subGrupoProdutoDao;
	private SubGrupoProduto subGrupoProduto = new SubGrupoProduto();
	private List<SubGrupoProduto> subGrupoProdutos;
	
	private SubGrupoProdutoFiltro subGrupoProdutoFiltro;
	
	@Inject
	private GrupoProdutoDao grupoProdutoDao;
	private Long cdGrupoProduto;
	
	public SubGrupoProdutoBean() {
		subGrupoProdutoFiltro = new SubGrupoProdutoFiltro();
		subGrupoProduto = new SubGrupoProduto();
		subGrupoProdutos = null;
	}
	
	public SubGrupoProdutoFiltro getSubGrupoProdutoFiltro() {
		return subGrupoProdutoFiltro;
	}

	@Transacional
	public void salvar(){
		if(subGrupoProduto.getDsSubGrupoProduto() == null || subGrupoProduto.getDsSubGrupoProduto().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição do subgrupo do produto é obrigatória!");
		} else if(cdGrupoProduto == null ){
			MensagemUtil.addMensagemDeAviso("Atenção", "Informar o grupo do produto é obrigatório!");
		} else {
			GrupoProduto grupoProduto = grupoProdutoDao.pesquisarPorId(cdGrupoProduto);
			subGrupoProduto.setGrupoProduto(grupoProduto);
			
			if(subGrupoProduto.getCdSubGrupoProduto() == null){
				subGrupoProdutoDao.inserir(subGrupoProduto);
			}else{
				subGrupoProdutoDao.atualizar(subGrupoProduto);
			}
			subGrupoProduto = new SubGrupoProduto();
			subGrupoProdutos = subGrupoProdutoDao.listarSubGrupoProdutos();
			cdGrupoProduto = null;
			MensagemUtil.addMensagemInformativa("Informação","Subgrupo do produto gravado com sucesso!");
		}
	}

	public void alterar(SubGrupoProduto subGrupoProduto){
		this.subGrupoProduto = subGrupoProduto;
		cdGrupoProduto = subGrupoProduto.getGrupoProduto().getCdGrupoProduto();
	}
	
	public Long getCdGrupoProduto() {
		return cdGrupoProduto;
	}

	public void setCdGrupoProduto(Long cdGrupoProduto) {
		this.cdGrupoProduto = cdGrupoProduto;
	}

	@Transacional
	public void remover(SubGrupoProduto subGrupoProduto){
		subGrupoProdutoDao.remover(subGrupoProduto);
		subGrupoProdutos = subGrupoProdutoDao.listarSubGrupoProdutos();
		MensagemUtil.addMensagemInformativa("Informação","Subgrupo do produto excluído com sucesso!");
	}
	
	public List<SubGrupoProduto> getSubGrupoProdutos(){
		if(subGrupoProdutos == null){
			subGrupoProdutos = subGrupoProdutoDao.listarSubGrupoProdutos();
		}
		return subGrupoProdutos;
	}

	public List<SubGrupoProduto> pesquisaSubGrupoProdutos() {
		subGrupoProdutos = subGrupoProdutoDao.pesquisarSubGrupoProdutos(subGrupoProdutoFiltro);
		return subGrupoProdutos;
	}

	public SubGrupoProduto getSubGrupoProduto() {
	   if (subGrupoProduto == null){  
		   subGrupoProduto = new SubGrupoProduto();  
	    }  
	    return subGrupoProduto;
	}

	public void setSubGrupoProduto(SubGrupoProduto subGrupoProduto) {
		this.subGrupoProduto = subGrupoProduto;
	}
}
