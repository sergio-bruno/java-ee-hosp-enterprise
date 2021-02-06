package br.gov.pe.sismepe.ehospenterprise.filtro;

import java.io.Serializable;

public class GrupoProdutoFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dsGrupoProduto;

	public String getDsGrupoProduto() {
		return dsGrupoProduto;
	}

	public void setDsGrupoProduto(String dsGrupoProduto) {
		this.dsGrupoProduto = dsGrupoProduto;
	}


}