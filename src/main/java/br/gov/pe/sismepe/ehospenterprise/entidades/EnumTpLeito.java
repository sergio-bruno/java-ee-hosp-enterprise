/**
 * Classe EnumSexo.java
 * Classe implementada para múltipla seleção de sexo
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

public enum EnumTpLeito {

	Q("Quarto"), 
	E("Enfermaria"),
	A("Apartamento"),
	U("UTI"),
	R("Repouso");
	
	private String descricao;
	
	EnumTpLeito(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
