/**
 * Classe EnumSexo.java
 * Classe implementada para seleção de sim e não
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

public enum EnumSimNao {

	S("Sim"), 
	N("Não"); 
	
	private String descricao;
	
	EnumSimNao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
