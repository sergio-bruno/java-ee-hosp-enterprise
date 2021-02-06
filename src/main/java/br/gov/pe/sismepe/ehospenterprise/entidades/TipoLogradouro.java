/**
 * Classe TipoLogradouro.java
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
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_logradouro")
public class TipoLogradouro implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdTipoLogradouro;
    private String dsTipoLogradouro;
    private String dsTipoLogradouroAbrev;

    @Id
    @GeneratedValue
    @Column(name="CD_TIPO_LOGRADOURO")
    public Long getCdTipoLogradouro() {
        return cdTipoLogradouro;
    }
    public void setCdTipoLogradouro(Long cdTipoLogradouro) {
        this.cdTipoLogradouro = cdTipoLogradouro;
    }

    @Size(max = 100)
    @Column(name="DS_TIPO_LOGRADOURO", length = 100)
    public String getDsTipoLogradouro() {
        return dsTipoLogradouro;
    }
    public void setDsTipoLogradouro(String dsTipoLogradouro) {
        this.dsTipoLogradouro = dsTipoLogradouro;
    }

    @Size(max = 20)
    @Column(name="DS_TIPO_LOGRADOURO_ABREV", length = 20)
    public String getDsTipoLogradouroAbrev() {
        return dsTipoLogradouroAbrev;
    }
    public void setDsTipoLogradouroAbrev(String dsTipoLogradouroAbrev) {
        this.dsTipoLogradouroAbrev = dsTipoLogradouroAbrev;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdTipoLogradouro == null) ? 0 : cdTipoLogradouro.hashCode());
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
        TipoLogradouro other = (TipoLogradouro) obj;
        if (cdTipoLogradouro == null) {
            if (other.cdTipoLogradouro != null)
                return false;
        } else if (!cdTipoLogradouro.equals(other.cdTipoLogradouro))
            return false;
        return true;
    }

}
