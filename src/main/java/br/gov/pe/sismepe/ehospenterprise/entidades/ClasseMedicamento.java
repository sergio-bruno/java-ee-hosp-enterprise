/**
 * Classe ClasseMedicamento.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "classe_medicamento")
public class ClasseMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdClasseMedicamento;
    private String dsClasseMedicamento;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @GeneratedValue
    @Column(name="CD_CLASSE_MEDICAMENTO")
    public Long getCdClasseMedicamento() {
        return cdClasseMedicamento;
    }
    public void setCdClasseMedicamento(Long cdClasseMedicamento) {
        this.cdClasseMedicamento = cdClasseMedicamento;
    }
    
    @NotNull
    @Size(max = 300)
    @Column(name="DS_CLASSE_MEDICAMENTO", length = 300, nullable = false )
    public String getDsClasseMedicamento() {
        return dsClasseMedicamento;
    }
    public void setDsClasseMedicamento(String dsClasseMedicamento) {
        this.dsClasseMedicamento = dsClasseMedicamento;
    }

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_ATIVO", nullable = false, length = 1)
	public EnumSimNao getSnAtivo() {
		return snAtivo;
	}
	public void setSnAtivo(EnumSimNao snAtivo) {
		this.snAtivo = snAtivo;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdClasseMedicamento == null) ? 0 : cdClasseMedicamento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClasseMedicamento other = (ClasseMedicamento) obj;
        if (cdClasseMedicamento == null) {
            if (other.cdClasseMedicamento != null)
                return false;
        } else if (!cdClasseMedicamento.equals(other.cdClasseMedicamento))
            return false;
        return true;
    }

}
