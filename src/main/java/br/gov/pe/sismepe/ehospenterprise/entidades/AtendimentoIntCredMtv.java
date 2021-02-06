/**
 * Classe AtendimentoIntCredMtv.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atendimento_int_cred_mtv")
public class AtendimentoIntCredMtv implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdAtendimentoIntCredMtv;
    private Atendimento atendimento;
    private String obsMotivo;

    @Id
    @GeneratedValue
    @Column(name="CD_ATENDIMENTO_INT_CRED_MTV")
    public Long getCdAtendimentoIntCredMtv() {
        return cdAtendimentoIntCredMtv;
    }
    public void setCdAtendimentoIntCredMtv(Long cdAtendimentoIntCredMtv) {
        this.cdAtendimentoIntCredMtv = cdAtendimentoIntCredMtv;
    }

	@ManyToOne
	@JoinColumn(name = "CD_ATENDIMENTO", nullable = false)
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

    @Column(name="OBS_MOTIVO", columnDefinition = "text")
    public String getObsMotivo() {
        return obsMotivo;
    }
    public void setObsMotivo(String obsMotivo) {
        this.obsMotivo = obsMotivo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdAtendimentoIntCredMtv == null) ? 0 : cdAtendimentoIntCredMtv.hashCode());
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
        AtendimentoIntCredMtv other = (AtendimentoIntCredMtv) obj;
        if (cdAtendimentoIntCredMtv == null) {
            if (other.cdAtendimentoIntCredMtv != null)
                return false;
        } else if (!cdAtendimentoIntCredMtv.equals(other.cdAtendimentoIntCredMtv))
            return false;
        return true;
    }

}
