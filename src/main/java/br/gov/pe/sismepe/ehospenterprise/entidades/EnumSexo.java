/**
 * Classe EnumSexo.java
 * Classe implementada para múltipla seleção de sexo
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

public enum EnumSexo {

	M("Masculino"), 
	F("Feminino"),
	A("Ambos");
	
	private String descricao;
	
	EnumSexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
