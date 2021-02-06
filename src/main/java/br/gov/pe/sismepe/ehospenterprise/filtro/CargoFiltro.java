package br.gov.pe.sismepe.ehospenterprise.filtro;

import java.io.Serializable;

public class CargoFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dsCargo;

	public String getDsCargo() {
		return dsCargo;
	}

	public void setDsCargo(String dsCargo) {
		this.dsCargo = dsCargo;
	}


}