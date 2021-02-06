/**
 * Classe UnidadeAtendimentoBean.java
 * Classe principal de bean para o unidadeAtendimento, usada para comunica��o com o front-end
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
import br.gov.pe.sismepe.ehospenterprise.dao.UnidadeAtendimentoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cidade;
import br.gov.pe.sismepe.ehospenterprise.entidades.Empresa;
import br.gov.pe.sismepe.ehospenterprise.entidades.Endereco;
import br.gov.pe.sismepe.ehospenterprise.entidades.TipoLogradouro;
import br.gov.pe.sismepe.ehospenterprise.entidades.Uf;
import br.gov.pe.sismepe.ehospenterprise.entidades.UnidadeAtendimento;
import br.gov.pe.sismepe.ehospenterprise.filtro.EmpresaFiltro;
import br.gov.pe.sismepe.ehospenterprise.filtro.UnidadeAtendimentoFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class UnidadeAtendimentoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	UnidadeAtendimentoDao unidadeAtendimentoDao;
	@Inject
	CidadeDao cidadeDao;
	@Inject
	TipoLogradouroDao tipoLogradouroDao;
	@Inject
	UfDao ufDao;
	@Inject
	EmpresaDao empresaDao;
	
	private UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
	private List<UnidadeAtendimento> unidadeAtendimentos;
	private UnidadeAtendimentoFiltro unidadeAtendimentoFiltro;
	private EmpresaFiltro empresaFiltro;

	public UnidadeAtendimentoBean() {
		unidadeAtendimentoFiltro = new UnidadeAtendimentoFiltro();
		unidadeAtendimentos = null;
		unidadeAtendimento.setEndereco(new Endereco());
		empresaFiltro = new EmpresaFiltro();
	}

	public UnidadeAtendimentoFiltro getUnidadeAtendimentoFiltro() {
		return unidadeAtendimentoFiltro;
	}

	@Transacional
	public void salvar(){
		if(unidadeAtendimento.getDsUnidadeAtendimento() == null || unidadeAtendimento.getDsUnidadeAtendimento().equals("")){
			MensagemUtil.addMensagemDeAviso("Aten��o", "O Nome da unidade de atendimento � obrigat�rio!");
		} else if(unidadeAtendimento.getEndereco().getDsLogradouro() == null || unidadeAtendimento.getEndereco().getDsLogradouro().equals("")){
			MensagemUtil.addMensagemDeAviso("Aten��o", "� necess�rio informar o logradouro!");
		} else if(unidadeAtendimento.getEndereco().getNmBairro() == null || unidadeAtendimento.getEndereco().getNmBairro().equals("")){
			MensagemUtil.addMensagemDeAviso("Aten��o", "� necess�rio informar o bairro!");
		} else if(unidadeAtendimento.getEndereco().getCidade().getDsCidade() == null || unidadeAtendimento.getEndereco().getCidade().getDsCidade().equals("")){
			MensagemUtil.addMensagemDeAviso("Aten��o", "� necess�rio informar a cidade!");
		} else if(unidadeAtendimento.getEndereco().getUf().getDsUf() == null || unidadeAtendimento.getEndereco().getUf().getDsUf().equals("")){
			MensagemUtil.addMensagemDeAviso("Aten��o", "� necess�rio informar a UF!");
		} else if(unidadeAtendimento.getEndereco().getNrCep() == null || unidadeAtendimento.getEndereco().getNrCep().equals("")){
			MensagemUtil.addMensagemDeAviso("Aten��o", "� necess�rio informar o CEP!");
		} else if(unidadeAtendimento.getSnAtivo() == null || unidadeAtendimento.getSnAtivo().equals("")){
				MensagemUtil.addMensagemDeAviso("Aten��o", "� necess�rio informar se esta unidade de atendimento encontra-se ativa!");
		} else {
			if(unidadeAtendimento.getCdUnidadeAtendimento() == null){
				unidadeAtendimentoDao.inserir(unidadeAtendimento);
			}else{
				unidadeAtendimentoDao.atualizar(unidadeAtendimento);
			}
			unidadeAtendimento = new UnidadeAtendimento();
			unidadeAtendimentos = unidadeAtendimentoDao.listarUnidadeAtendimentos();
			MensagemUtil.addMensagemInformativa("Informa��o", "Unidade de atendimento gravada com sucesso!");
		}
	}

	public void alterar(UnidadeAtendimento unidadeAtendimento){
		this.unidadeAtendimento = unidadeAtendimento;
	}
	
	@Transacional
	public void remover(UnidadeAtendimento unidadeAtendimento){
		unidadeAtendimentoDao.remover(unidadeAtendimento);
		unidadeAtendimentos = unidadeAtendimentoDao.listarUnidadeAtendimentos();
		MensagemUtil.addMensagemInformativa("Informa��o", "Unidade de atendimento exclu�da com sucesso!");
	}
	
	public List<UnidadeAtendimento> getUnidadeAtendimentos(){
		if(unidadeAtendimentos == null){
			unidadeAtendimentos = unidadeAtendimentoDao.listarUnidadeAtendimentos();
		}
		return unidadeAtendimentos;
	}
									
	public List<UnidadeAtendimento> pesquisaUnidadeAtendimentos() {
		unidadeAtendimentos = unidadeAtendimentoDao.pesquisarUnidadeAtendimentos(unidadeAtendimentoFiltro);
		return unidadeAtendimentos;
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

	// Para o autocomplete da tela
	public List<Empresa> completarEmpresas(String descricao) {
		empresaFiltro.setNmRazaoSocial(descricao);;
		return empresaDao.pesquisarEmpresas(empresaFiltro);
	}
	
	public UnidadeAtendimento getUnidadeAtendimento() {
	   if (unidadeAtendimento == null){  
		   unidadeAtendimento = new UnidadeAtendimento(); 
		   unidadeAtendimento.setEndereco(new Endereco());
		   empresaFiltro = new EmpresaFiltro();
	    }  
	    return unidadeAtendimento;
	}

	public void setUnidadeAtendimento(UnidadeAtendimento unidadeAtendimento) {
		this.unidadeAtendimento = unidadeAtendimento;
	}
}
