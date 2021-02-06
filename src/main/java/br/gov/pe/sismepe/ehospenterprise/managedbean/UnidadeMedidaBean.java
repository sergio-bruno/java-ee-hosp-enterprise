/**
 * Classe UnidadeMedidaBean.java
 * Classe principal de bean para a unidade de medida, usada para comunicação com o front-end
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

import br.gov.pe.sismepe.ehospenterprise.dao.UnidadeMedidaDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.UnidadeMedida;
import br.gov.pe.sismepe.ehospenterprise.filtro.UnidadeMedidaFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class UnidadeMedidaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	UnidadeMedidaDao unidadeMedidaDao;
	private UnidadeMedida unidadeMedida = new UnidadeMedida();
	private List<UnidadeMedida> unidadeMedidas;
	
	private UnidadeMedidaFiltro unidadeMedidaFiltro;
	
	public UnidadeMedidaBean() {
		unidadeMedidaFiltro = new UnidadeMedidaFiltro();
		unidadeMedida = new UnidadeMedida();
		unidadeMedidas = null;
	}
	
	public UnidadeMedidaFiltro getUnidadeMedidaFiltro() {
		return unidadeMedidaFiltro;
	}

	@Transacional
	public void salvar(){
		if(unidadeMedida.getDsUnidadeMedida() == null || unidadeMedida.getDsUnidadeMedida().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição da unidade de medida é obrigatória!");
		} else {
			if(unidadeMedida.getCdUnidadeMedida() == null){
				unidadeMedidaDao.inserir(unidadeMedida);
			}else{
				unidadeMedidaDao.atualizar(unidadeMedida);
			}
			unidadeMedida = new UnidadeMedida();
			unidadeMedidas = unidadeMedidaDao.listarUnidadeMedidas();
			MensagemUtil.addMensagemInformativa("Informação","Unidade de medida gravada com sucesso!");
		}
	}

	@Transacional
	public void remover(UnidadeMedida unidadeMedida){
		unidadeMedidaDao.remover(unidadeMedida);
		unidadeMedidas = unidadeMedidaDao.listarUnidadeMedidas();
		MensagemUtil.addMensagemInformativa("Informação","Unidade de medida excluída com sucesso!");
	}
	
	public List<UnidadeMedida> getUnidadeMedidas(){
		if(unidadeMedidas == null){
			unidadeMedidas = unidadeMedidaDao.listarUnidadeMedidas();
		}
		return unidadeMedidas;
	}

	public List<UnidadeMedida> pesquisaUnidadeMedidas() {
		unidadeMedidas = unidadeMedidaDao.pesquisarUnidadeMedidas(unidadeMedidaFiltro);
		return unidadeMedidas;
	}

	public UnidadeMedida getUnidadeMedida() {
	   if (unidadeMedida == null){  
		   unidadeMedida = new UnidadeMedida();  
	    }  
	    return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
}
