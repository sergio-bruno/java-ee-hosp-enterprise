/**
 * Classe cidBean.java
 * Classe principal de bean para o cid, usada para comunicação com o front-end
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.pe.sismepe.ehospenterprise.dao.CidDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cid;
import br.gov.pe.sismepe.ehospenterprise.filtro.CidFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class CidBean implements Serializable {
	
	public void setCidFiltro(CidFiltro cidFiltro) {
		this.cidFiltro = cidFiltro;
	}

	private static final long serialVersionUID = 1L;
	
	@Inject
	CidDao cidDao;
	private Cid cid = new Cid();
	private List<Cid> cids;
	private CidFiltro cidFiltro;
	
	public CidBean() {
		cidFiltro = new CidFiltro();
		cid = new Cid();
		cids = null;
	}
	
	@Transacional
	public void salvar(){
		if(cid.getDsCid() == null || cid.getDsCid().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição do cid é obrigatória!");
		} else {
			if(cid.getCdCid() == null){
				cidDao.inserir(cid);
			}else{
				cidDao.atualizar(cid);
			}
			cid = new Cid();
			cids = cidDao.listarCids();
			MensagemUtil.addMensagemInformativa("Informação","Cid gravado com sucesso!");
		}
	}

	@Transacional
	public void remover(Cid cid){
		cidDao.remover(cid);
		cids = cidDao.listarCids();
		MensagemUtil.addMensagemInformativa("Informação","Cid excluído com sucesso!");
	}
	
	public CidFiltro getCidFiltro() {
		return cidFiltro;
	}

	public List<Cid> getCids(){
		if(cids == null){
			cids = cidDao.listarCids();
		}
		return cids;
	}

	public List<Cid> pesquisaCids() {
		return cidDao.pesquisarCids(cidFiltro);
	}
	
	public Cid getCid() {
	   if (cid == null){  
		   cid = new Cid();  
	    }  
	    return cid;
	}

	public void setCid(Cid cid) {
		this.cid = cid;
	}
	
}
