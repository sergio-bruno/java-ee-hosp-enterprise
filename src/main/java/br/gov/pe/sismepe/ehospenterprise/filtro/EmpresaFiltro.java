package br.gov.pe.sismepe.ehospenterprise.filtro;

import java.io.Serializable;

public class EmpresaFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nmRazaoSocial;

	public String getNmRazaoSocial() {
		return nmRazaoSocial;
	}

	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}


}