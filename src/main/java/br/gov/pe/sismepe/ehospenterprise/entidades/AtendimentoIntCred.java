/**
 * Classe AtendimentoIntCred.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "atendimento_int_cred")
public class AtendimentoIntCred implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdAtendimento;
    private Long cdUnidadeAtendimento;
    private String tpProcedimento;
    private String tpLeito;
    private Long cdMotivoAlta;
    private Long cdPrestadorAlta;
    private String obsAlta;
    private Long cdAtendimentoOrigem;
    
	@Id
    @Column(name="CD_ATENDIMENTO")
    public Long getCdAtendimento() {
        return cdAtendimento;
    }
    public void setCdAtendimento(Long cdAtendimento) {
        this.cdAtendimento = cdAtendimento;
    }

    @NotNull
    @NotBlank
    @Column(name="CD_UNIDADE_ATENDIMENTO", nullable = false )
    public Long getCdUnidadeAtendimento() {
        return cdUnidadeAtendimento;
    }
    public void setCdUnidadeAtendimento(Long cdUnidadeAtendimento) {
        this.cdUnidadeAtendimento = cdUnidadeAtendimento;
    }

    @NotNull
    @NotBlank
    @Size(max = 1)
    @Column(name="TP_PROCEDIMENTO", length = 1, nullable = false )
    public String getTpProcedimento() {
        return tpProcedimento;
    }
    public void setTpProcedimento(String tpProcedimento) {
        this.tpProcedimento = tpProcedimento;
    }

    @NotNull
    @NotBlank
    @Size(max = 1)
    @Column(name="TP_LEITO", length = 1, nullable = false )
    public String getTpLeito() {
        return tpLeito;
    }
    public void setTpLeito(String tpLeito) {
        this.tpLeito = tpLeito;
    }

    @Column(name="CD_MOTIVO_ALTA")
    public Long getCdMotivoAlta() {
        return cdMotivoAlta;
    }
    public void setCdMotivoAlta(Long cdMotivoAlta) {
        this.cdMotivoAlta = cdMotivoAlta;
    }

    @Column(name="CD_PRESTADOR_ALTA")
    public Long getCdPrestadorAlta() {
        return cdPrestadorAlta;
    }
    public void setCdPrestadorAlta(Long cdPrestadorAlta) {
        this.cdPrestadorAlta = cdPrestadorAlta;
    }

    @Column(name="OBS_ALTA", columnDefinition = "text")
    public String getObsAlta() {
        return obsAlta;
    }
    public void setObsAlta(String obsAlta) {
        this.obsAlta = obsAlta;
    }

    @Column(name="CD_ATENDIMENTO_ORIGEM")
    public Long getCdAtendimentoOrigem() {
        return cdAtendimentoOrigem;
    }
    public void setCdAtendimentoOrigem(Long cdAtendimentoOrigem) {
        this.cdAtendimentoOrigem = cdAtendimentoOrigem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdAtendimento == null) ? 0 : cdAtendimento.hashCode());
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
        AtendimentoIntCred other = (AtendimentoIntCred) obj;
        if (cdAtendimento == null) {
            if (other.cdAtendimento != null)
                return false;
        } else if (!cdAtendimento.equals(other.cdAtendimento))
            return false;
        return true;
    }

}
