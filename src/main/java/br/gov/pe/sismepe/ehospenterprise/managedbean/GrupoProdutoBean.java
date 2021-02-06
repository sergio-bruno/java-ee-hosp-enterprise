/**
 * Classe grupoProdutoBean.java
 * Classe principal de bean para o grupoProduto, usada para comunicação com o front-end
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
import br.gov.pe.sismepe.ehospenterprise.entidades.GrupoProduto;
import br.gov.pe.sismepe.ehospenterprise.filtro.GrupoProdutoFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class GrupoProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	GrupoProdutoDao grupoProdutoDao;
	private GrupoProduto grupoProduto = new GrupoProduto();
	private List<GrupoProduto> grupoProdutos;
	
	private GrupoProdutoFiltro grupoProdutoFiltro;
	
	public GrupoProdutoBean() {
		grupoProdutoFiltro = new GrupoProdutoFiltro();
		grupoProduto = new GrupoProduto();
		grupoProdutos = null;
	}
	
	public GrupoProdutoFiltro getGrupoProdutoFiltro() {
		return grupoProdutoFiltro;
	}

	@Transacional
	public void salvar(){
		if(grupoProduto.getDsGrupoProduto() == null || grupoProduto.getDsGrupoProduto().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição do grupo do produto é obrigatória!");
		} else {
			if(grupoProduto.getCdGrupoProduto() == null){
				grupoProdutoDao.inserir(grupoProduto);
			}else{
				grupoProdutoDao.atualizar(grupoProduto);
			}
			grupoProduto = new GrupoProduto();
			grupoProdutos = grupoProdutoDao.listarGrupoProdutos();
			MensagemUtil.addMensagemInformativa("Informação","Grupo do produto gravado com sucesso!");
		}
	}

	@Transacional
	public void remover(GrupoProduto grupoProduto){
		grupoProdutoDao.remover(grupoProduto);
		grupoProdutos = grupoProdutoDao.listarGrupoProdutos();
		MensagemUtil.addMensagemInformativa("Informação","Grupo do produto excluído com sucesso!");
	}
	
	public List<GrupoProduto> getGrupoProdutos(){
		if(grupoProdutos == null){
			grupoProdutos = grupoProdutoDao.listarGrupoProdutos();
		}
		return grupoProdutos;
	}

	public List<GrupoProduto> pesquisaGrupoProdutos() {
		grupoProdutos = grupoProdutoDao.pesquisarGrupoProdutos(grupoProdutoFiltro);
		return grupoProdutos;
	}

	public GrupoProduto getGrupoProduto() {
	   if (grupoProduto == null){  
		   grupoProduto = new GrupoProduto();  
	    }  
	    return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}
}
