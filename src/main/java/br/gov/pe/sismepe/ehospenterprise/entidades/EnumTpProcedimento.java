/**
 * Classe EnumSexo.java
 * Classe implementada para m�ltipla sele��o de sexo
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

public enum EnumTpProcedimento {

	C("Cl�nico"), 
	R("Cir�rgico");
	
	private String descricao;
	
	EnumTpProcedimento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
