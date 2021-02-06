/**
 * Classe cargoBean.java
 * Classe principal de bean para o cargo, usada para comunicação com o front-end
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

import br.gov.pe.sismepe.ehospenterprise.dao.CargoDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cargo;
import br.gov.pe.sismepe.ehospenterprise.filtro.CargoFiltro;
import br.gov.pe.sismepe.ehospenterprise.interceptadores.Transacional;
import br.gov.pe.sismepe.ehospenterprise.sessao.SessionContext;
import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Named
@ViewScoped
public class CargoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	CargoDao cargoDao;
	private Cargo cargo = new Cargo();
	private List<Cargo> cargos;
	private CargoFiltro cargoFiltro;
	
	public CargoBean() {
		cargoFiltro = new CargoFiltro();
		cargo = new Cargo();
		cargos = null;
	}
	
	public CargoFiltro getCargoFiltro() {
		return cargoFiltro;
	}

	@Transacional
	public void salvar(){
		System.out.print("Cargo->setor: "+SessionContext.getInstance().getAttribute("setor")+"\n");
		if(cargo.getDsCargo() == null || cargo.getDsCargo().equals("")){
			MensagemUtil.addMensagemDeAviso("Atenção", "A descrição do cargo é obrigatória!");
		} else {
			if(cargo.getCdCargo() == null){
				cargoDao.inserir(cargo);
			}else{
				cargoDao.atualizar(cargo);
			}
			cargo = new Cargo();
			cargos = cargoDao.listarCargos();
			MensagemUtil.addMensagemInformativa("Informação","Cargo gravado com sucesso!");
		}
	}

	@Transacional
	public void remover(Cargo cargo){
		cargoDao.remover(cargo);
		cargos = cargoDao.listarCargos();
		MensagemUtil.addMensagemInformativa("Informação","Cargo excluído com sucesso!");
	}
	
	public List<Cargo> getCargos(){
		if(cargos == null){
			cargos = cargoDao.listarCargos();
		}
		return cargos;
	}

	public List<Cargo> pesquisaCargos() {
		cargos = cargoDao.pesquisarCargos(cargoFiltro);
		return cargos;
	}

	public Cargo getCargo() {
	   if (cargo == null){  
		   cargo = new Cargo();  
	    }  
	    return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
