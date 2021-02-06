/**
 * Classe CategoriaCid.java
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
@Table(name = "categoria_cid")
public class CategoriaCid implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cdCategoriaCid;
    private String tpClassificacao;
    private String dsCategoriaCid;
    private String dsCategoriaCidAbrev;
    private String snAtivo;

    @Id
    @Column(name="CD_CATEGORIA_CID")
    public String getCdCategoriaCid() {
        return cdCategoriaCid;
    }
    public void setCdCategoriaCid(String cdCategoriaCid) {
        this.cdCategoriaCid = cdCategoriaCid;
    }

    @Size(max = 1)
    @Column(name="TP_CLASSIFICACAO", length = 1)
    public String getTpClassificacao() {
        return tpClassificacao;
    }
    public void setTpClassificacao(String tpClassificacao) {
        this.tpClassificacao = tpClassificacao;
    }

    @NotNull
    @NotBlank
    @Size(max = 300)
    @Column(name="DS_CATEGORIA_CID", length = 300, nullable = false )
    public String getDsCategoriaCid() {
        return dsCategoriaCid;
    }
    public void setDsCategoriaCid(String dsCategoriaCid) {
        this.dsCategoriaCid = dsCategoriaCid;
    }

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name="DS_CATEGORIA_CID_ABREV", length = 100, nullable = false )
    public String getDsCategoriaCidAbrev() {
        return dsCategoriaCidAbrev;
    }
    public void setDsCategoriaCidAbrev(String dsCategoriaCidAbrev) {
        this.dsCategoriaCidAbrev = dsCategoriaCidAbrev;
    }

    @NotNull
    @NotBlank
    @Size(max = 1)
    @Column(name="SN_ATIVO", length = 1, nullable = false )
    public String getSnAtivo() {
        return snAtivo;
    }
    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdCategoriaCid == null) ? 0 : cdCategoriaCid.hashCode());
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
        CategoriaCid other = (CategoriaCid) obj;
        if (cdCategoriaCid == null) {
            if (other.cdCategoriaCid != null)
                return false;
        } else if (!cdCategoriaCid.equals(other.cdCategoriaCid))
            return false;
        return true;
    }

}
