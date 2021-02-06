/**
 * Classe EnumSexo.java
 * Classe implementada para múltipla seleção de especialidades médicas
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

public enum EnumTpEspecialidade {

	O("Odontológica"), 
	M("Médica"); 
	
	private String descricao;
	
	EnumTpEspecialidade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}