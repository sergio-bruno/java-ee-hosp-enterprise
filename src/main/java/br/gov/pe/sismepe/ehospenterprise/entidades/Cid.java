/**
 * Classe Cid.java
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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cid")
public class Cid implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cdCid;
    private CategoriaCid categoriaCid;
    private String tpClassificacao;
    private EnumSexo tpSexo = EnumSexo.A;
    private String dsCid;
    private String dsCidAbrev;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @Column(name="CD_CID")
    public String getCdCid() {
        return cdCid;
    }
    public void setCdCid(String cdCid) {
        this.cdCid = cdCid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_CATEGORIA_CID", referencedColumnName = "CD_CATEGORIA_CID", nullable = false)
    public CategoriaCid getCategoriaCid() {
        return categoriaCid;
    }
    public void setCategoriaCid(CategoriaCid categoriaCid) {
        this.categoriaCid = categoriaCid;
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
	@Enumerated(EnumType.STRING)
    @Column(name="TP_SEXO", length = 1, nullable = false )
    public EnumSexo getTpSexo() {
        return tpSexo;
    }
    public void setTpSexo(EnumSexo tpSexo) {
        this.tpSexo = tpSexo;
    }

    @NotNull
    @Size(max = 300)
    @Column(name="DS_CID", length = 300, nullable = false )
    public String getDsCid() {
        return dsCid;
    }
    public void setDsCid(String dsCid) {
        this.dsCid = dsCid;
    }

    @NotNull
    @Size(max = 100)
    @Column(name="DS_CID_ABREV", length = 100, nullable = false )
    public String getDsCidAbrev() {
        return dsCidAbrev;
    }
    public void setDsCidAbrev(String dsCidAbrev) {
        this.dsCidAbrev = dsCidAbrev;
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
        result = prime * result + ((cdCid == null) ? 0 : cdCid.hashCode());
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
        Cid other = (Cid) obj;
        if (cdCid == null) {
            if (other.cdCid != null)
                return false;
        } else if (!cdCid.equals(other.cdCid))
            return false;
        return true;
    }

}
