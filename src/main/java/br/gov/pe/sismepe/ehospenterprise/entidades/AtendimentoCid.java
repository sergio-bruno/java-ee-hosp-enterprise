/**
 * Classe AtendimentoCid.java
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "atendimento_cid")
public class AtendimentoCid implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdAtendimentoCid;
    private Cid cid;
    private EnumSimNao snPrincipal = EnumSimNao.S;
    private Atendimento atendimento;

    @Id
    @GeneratedValue
    @Column(name="CD_ATENDIMENTO_CID")
    public Long getCdAtendimentoCid() {
        return cdAtendimentoCid;
    }
    public void setCdAtendimentoCid(Long cdAtendimentoCid) {
        this.cdAtendimentoCid = cdAtendimentoCid;
    }

    @ManyToOne
    @JoinColumn(name = "CD_CID", referencedColumnName = "CD_CID", nullable = false)
    public Cid getCid() {
        return cid;
    }
    public void setCid(Cid cid) {
        this.cid = cid;
    }

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_ATIVO", nullable = false, length = 1)
	public EnumSimNao getSnPrincipal() {
		return snPrincipal;
	}
	public void setSnPrincipal(EnumSimNao snPrincipal) {
		this.snPrincipal = snPrincipal;
	}
    
	@ManyToOne
	@JoinColumn(name = "CD_ATENDIMENTO", nullable = false)
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdAtendimentoCid == null) ? 0 : cdAtendimentoCid.hashCode());
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
        AtendimentoCid other = (AtendimentoCid) obj;
        if (cdAtendimentoCid == null) {
            if (other.cdAtendimentoCid != null)
                return false;
        } else if (!cdAtendimentoCid.equals(other.cdAtendimentoCid))
            return false;
        return true;
    }

}
