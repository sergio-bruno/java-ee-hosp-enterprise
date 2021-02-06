/**
 * Classe EmpresaBean.java
 * Classe principal de bean para o empresa, usada para comunicação com o front-end
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
import br.gov.pe.sismepe.ehospenterprise.dao.EmpresaDao;
import br.gov.pe.sismepe.ehospenterprise.dao.TipoLogradouroDao;
import br.gov.pe.sismepe.ehospenterprise.dao.UfDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cidade;
import br.gov.pe.sismepe.ehospenterprise.entidades.Endereco;
import br.gov.pe.sismepe.ehospenterprise.entidades.Empresa;
import br.gov.pe.sismepe.ehospenterprise.entidades.TipoLogradouro;
import br.gov.pe.sismepe.ehospenterprise.entidades.Uf;
import br.gov.pe.sismepe.ehospenterprise.filtro.EmpresaFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	EmpresaDao empresaDao;
	@Inject
	CidadeDao cidadeDao;
	@Inject
	TipoLogradouroDao tipoLogradouroDao;
	@Inject
	UfDao ufDao;

	private Empresa empresa = new Empresa();
	private List<Empresa> empresas;
	private EmpresaFiltro empresaFiltro;

	public EmpresaBean() {
		empresaFiltro = new EmpresaFiltro();
		empresas = null;
		empresa.setEndereco(new Endereco());
	}
	
	public EmpresaFiltro getEmpresaFiltro() {
		return empresaFiltro;
	}

	@Transacional
	public void salvar(){
		if(empresa.getNmRazaoSocial() == null || empresa.getNmRazaoSocial().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A razão social da empresa é obrigatório!");
		} if(empresa.getNmEmpresa() == null || empresa.getNmEmpresa().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "O nome de fantasia da empresa é obrigatório!");
		} else if(empresa.getSnAtivo() == null || empresa.getSnAtivo().equals("")){
				MensagemUtil.addMensagemDeAviso("Atenção", "É necessário informar se esta empresa encontra-se ativa!");
		} else {
			if(empresa.getCdEmpresa() == null){
				empresaDao.inserir(empresa);
			}else{
				empresaDao.atualizar(empresa);
			}
			empresa = new Empresa();
			empresas = empresaDao.listarEmpresas();
			MensagemUtil.addMensagemInformativa("Informação", "Empresa gravada com sucesso!");
		}
	}

	public void alterar(Empresa empresa){
		this.empresa = empresa;
	}
	
	@Transacional
	public void remover(Empresa empresa){
		empresaDao.remover(empresa);
		empresas = empresaDao.listarEmpresas();
		MensagemUtil.addMensagemInformativa("Informação", "Empresa excluída com sucesso!");
	}
	
	public List<Empresa> getEmpresas(){
		if(empresas == null){
			empresas = empresaDao.listarEmpresas();
		}
		return empresas;
	}

	public List<Empresa> pesquisaEmpresas() {
		empresas = empresaDao.pesquisarEmpresas(empresaFiltro);
		return empresas;
	}

	// Para o autocomplete da tela
	public List<Cidade> completarCidades(String descricao) {
		return cidadeDao.pesquisarCidades(descricao);
	}

	// Para o autocomplete da tela
	public List<TipoLogradouro> completarTipoLogradouros(String descricao) {
		return tipoLogradouroDao.pesquisarTipoLogradouros(descricao);
	}
	
	// Para o autocomplete da tela
	public List<Uf> completarUfs(String descricao) {
		return ufDao.pesquisarUfs(descricao);
	}
	
	public Empresa getEmpresa() {
	   if (empresa == null){  
		   empresa = new Empresa(); 
		   empresa.setEndereco(new Endereco());
	    }  
	    return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
