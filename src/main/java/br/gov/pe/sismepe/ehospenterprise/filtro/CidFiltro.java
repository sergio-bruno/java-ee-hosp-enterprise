package br.gov.pe.sismepe.ehospenterprise.filtro;

import java.io.Serializable;

public class CidFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdCid;
	private String dsCid;

	public String getDsCid() {
		return dsCid;
	}

	public void setDsCid(String dsCid) {
		this.dsCid = dsCid;
	}

	public String getCdCid() {
		return cdCid;
	}

	public void setCdCid(String cdCid) {
		this.cdCid = cdCid;
	}

}