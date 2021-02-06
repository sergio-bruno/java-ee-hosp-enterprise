/**
 * Classe TipoConselho.java
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
@Table(name = "tipo_conselho")
public class TipoConselho implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdTipoConselho;
    private String dsTipoConselho;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @GeneratedValue
    @Column(name="CD_TIPO_CONSELHO")
    public Long getCdTipoConselho() {
        return cdTipoConselho;
    }
    public void setCdTipoConselho(Long cdTipoConselho) {
        this.cdTipoConselho = cdTipoConselho;
    }

    @NotNull
    @Size(max = 300)
    @Column(name="DS_TIPO_CONSELHO", length = 300, nullable = false )
    public String getDsTipoConselho() {
        return dsTipoConselho;
    }
    public void setDsTipoConselho(String dsTipoConselho) {
        this.dsTipoConselho = dsTipoConselho;
    }

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_ATIVO", nullable = false, length = 20)    
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
        result = prime * result + ((cdTipoConselho == null) ? 0 : cdTipoConselho.hashCode());
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
        TipoConselho other = (TipoConselho) obj;
        if (cdTipoConselho == null) {
            if (other.cdTipoConselho != null)
                return false;
        } else if (!cdTipoConselho.equals(other.cdTipoConselho))
            return false;
        return true;
    }
    
}
