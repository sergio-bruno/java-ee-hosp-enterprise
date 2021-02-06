package br.gov.pe.sismepe.ehospenterprise.filtro;

import java.io.Serializable;

public class ClasseMedicamentoFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dsClasseMedicamento;

	public String getDsClasseMedicamento() {
		return dsClasseMedicamento;
	}

	public void setDsClasseMedicamento(String dsClasseMedicamento) {
		this.dsClasseMedicamento = dsClasseMedicamento;
	}


}