/**
 * Classe EnumSexo.java
 * Classe implementada para m�ltipla sele��o de especialidades m�dicas
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

public enum EnumTpPessoa {

	F("F�sica"), 
	J("Jur�dica"); 
	
	private String descricao;
	
	EnumTpPessoa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}