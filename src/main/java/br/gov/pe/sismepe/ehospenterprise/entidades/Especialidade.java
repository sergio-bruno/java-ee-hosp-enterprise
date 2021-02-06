/**
 * Classe Especialidade.java
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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "especialidade")
public class Especialidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdEspecialidade;
    private String dsEspecialidade;
    private String tpEspecialidade;
    private String dsObservacao;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @GeneratedValue
    @Column(name="CD_ESPECIALIDADE")
    public Long getCdEspecialidade() {
        return cdEspecialidade;
    }
    public void setCdEspecialidade(Long cdEspecialidade) {
        this.cdEspecialidade = cdEspecialidade;
    }

    @NotNull
    @NotBlank
    @Size(max = 300)
    @Column(name="DS_ESPECIALIDADE", length = 300, nullable = false )
    public String getDsEspecialidade() {
        return dsEspecialidade;
    }
    public void setDsEspecialidade(String dsEspecialidade) {
        this.dsEspecialidade = dsEspecialidade;
    }

    @Size(max = 1)
    @Column(name="TP_ESPECIALIDADE", length = 1)
    public String getTpEspecialidade() {
        return tpEspecialidade;
    }
    public void setTpEspecialidade(String tpEspecialidade) {
        this.tpEspecialidade = tpEspecialidade;
    }

    @Size(max = 1000)
    @Column(name="DS_OBSERVACAO", length = 1000)
    public String getDsObservacao() {
        return dsObservacao;
    }
    public void setDsObservacao(String dsObservacao) {
        this.dsObservacao = dsObservacao;
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
        result = prime * result + ((cdEspecialidade == null) ? 0 : cdEspecialidade.hashCode());
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
        Especialidade other = (Especialidade) obj;
        if (cdEspecialidade == null) {
            if (other.cdEspecialidade != null)
                return false;
        } else if (!cdEspecialidade.equals(other.cdEspecialidade))
            return false;
        return true;
    }

}
