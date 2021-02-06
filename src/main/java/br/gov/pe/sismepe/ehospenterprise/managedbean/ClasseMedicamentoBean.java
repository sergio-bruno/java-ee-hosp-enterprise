/**
 * Classe classeMedicamentoBean.java
 * Classe principal de bean para o classeMedicamento, usada para comunicação com o front-end
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

import br.gov.pe.sismepe.ehospenterprise.dao.ClasseMedicamentoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.ClasseMedicamento;
import br.gov.pe.sismepe.ehospenterprise.filtro.ClasseMedicamentoFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class ClasseMedicamentoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	ClasseMedicamentoDao classeMedicamentoDao;
	private ClasseMedicamento classeMedicamento = new ClasseMedicamento();
	private List<ClasseMedicamento> classeMedicamentos;
	
	private ClasseMedicamentoFiltro classeMedicamentoFiltro;
	
	public ClasseMedicamentoBean() {
		classeMedicamentoFiltro = new ClasseMedicamentoFiltro();
		classeMedicamento = new ClasseMedicamento();
		classeMedicamentos = null;
	}
	
	public ClasseMedicamentoFiltro getClasseMedicamentoFiltro() {
		return classeMedicamentoFiltro;
	}

	@Transacional
	public void salvar(){
		if(classeMedicamento.getDsClasseMedicamento() == null || classeMedicamento.getDsClasseMedicamento().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição do classe do medicamento é obrigatória!");
		} else {
			if(classeMedicamento.getCdClasseMedicamento() == null){
				classeMedicamentoDao.inserir(classeMedicamento);
			}else{
				classeMedicamentoDao.atualizar(classeMedicamento);
			}
			classeMedicamento = new ClasseMedicamento();
			classeMedicamentos = classeMedicamentoDao.listarClasseMedicamentos();
			MensagemUtil.addMensagemInformativa("Informação","Classe de medicamento gravado com sucesso!");
		}
	}

	@Transacional
	public void remover(ClasseMedicamento classeMedicamento){
		classeMedicamentoDao.remover(classeMedicamento);
		classeMedicamentos = classeMedicamentoDao.listarClasseMedicamentos();
		MensagemUtil.addMensagemInformativa("Informação","Classe de medicamento excluído com sucesso!");
	}
	
	public List<ClasseMedicamento> getClasseMedicamentos(){
		if(classeMedicamentos == null){
			classeMedicamentos = classeMedicamentoDao.listarClasseMedicamentos();
		}
		return classeMedicamentos;
	}

	public List<ClasseMedicamento> pesquisaClasseMedicamentos() {
		classeMedicamentos = classeMedicamentoDao.pesquisarClasseMedicamentos(classeMedicamentoFiltro);
		return classeMedicamentos;
	}

	public ClasseMedicamento getClasseMedicamento() {
	   if (classeMedicamento == null){  
		   classeMedicamento = new ClasseMedicamento();  
	    }  
	    return classeMedicamento;
	}

	public void setClasseMedicamento(ClasseMedicamento classeMedicamento) {
		this.classeMedicamento = classeMedicamento;
	}
}
