/**
 * Classe EnumSexo.java
 * Classe implementada para sele��o de sim e n�o
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

public enum EnumSimNao {

	S("Sim"), 
	N("N�o"); 
	
	private String descricao;
	
	EnumSimNao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
