/**
 * Classe Cidade.java
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
@Table(name = "cidade")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdCidade;
    private String dsCidade;
    private String snAtivo;
    private String cdIbge;

    @Id
    @GeneratedValue
    @Column(name="CD_CIDADE")
    public Long getCdCidade() {
        return cdCidade;
    }
    public void setCdCidade(Long cdCidade) {
        this.cdCidade = cdCidade;
    }

    @Size(max = 300)
    @Column(name="DS_CIDADE", length = 300)
    public String getDsCidade() {
        return dsCidade;
    }
    public void setDsCidade(String dsCidade) {
        this.dsCidade = dsCidade;
    }

    @Size(max = 1)
    @Column(name="SN_ATIVO", length = 1)
    public String getSnAtivo() {
        return snAtivo;
    }
    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }

    @Size(max = 7)
    @Column(name="CD_IBGE", length = 7)
    public String getCdIbge() {
        return cdIbge;
    }
    public void setCdIbge(String cdIbge) {
        this.cdIbge = cdIbge;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdCidade == null) ? 0 : cdCidade.hashCode());
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
        Cidade other = (Cidade) obj;
        if (cdCidade == null) {
            if (other.cdCidade != null)
                return false;
        } else if (!cdCidade.equals(other.cdCidade))
            return false;
        return true;
    }

}
