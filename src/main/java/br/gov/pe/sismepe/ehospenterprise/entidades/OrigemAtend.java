/**
 * Classe OrigemAtend.java
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
@Table(name = "origem_atend")
public class OrigemAtend implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdOrigemAtend;
    private String dsOrigemAtend;
    private String tpOrigemAtend;
    private EnumSimNao snAtivo = EnumSimNao.S;
    private Long cdSetor;

    @Id
    @GeneratedValue
    @Column(name="CD_ORIGEM_ATEND")
    public Long getCdOrigemAtend() {
        return cdOrigemAtend;
    }
    public void setCdOrigemAtend(Long cdOrigemAtend) {
        this.cdOrigemAtend = cdOrigemAtend;
    }

    @NotNull
    @NotBlank
    @Size(max = 300)
    @Column(name="DS_ORIGEM_ATEND", length = 300, nullable = false )
    public String getDsOrigemAtend() {
        return dsOrigemAtend;
    }
    public void setDsOrigemAtend(String dsOrigemAtend) {
        this.dsOrigemAtend = dsOrigemAtend;
    }

    @NotNull
    @NotBlank
    @Size(max = 1)
    @Column(name="TP_ORIGEM_ATEND", length = 1, nullable = false )
    public String getTpOrigemAtend() {
        return tpOrigemAtend;
    }
    public void setTpOrigemAtend(String tpOrigemAtend) {
        this.tpOrigemAtend = tpOrigemAtend;
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

    @NotNull
    @NotBlank
    @Column(name="CD_SETOR", nullable = false )
    public Long getCdSetor() {
        return cdSetor;
    }
    public void setCdSetor(Long cdSetor) {
        this.cdSetor = cdSetor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdOrigemAtend == null) ? 0 : cdOrigemAtend.hashCode());
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
        OrigemAtend other = (OrigemAtend) obj;
        if (cdOrigemAtend == null) {
            if (other.cdOrigemAtend != null)
                return false;
        } else if (!cdOrigemAtend.equals(other.cdOrigemAtend))
            return false;
        return true;
    }

}
