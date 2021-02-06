/**
 * Classe SubGrupoProduto.java
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
import javax.validation.constraints.Size;

@Entity
@Table(name = "subgrupo_produto")
public class SubGrupoProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdSubGrupoProduto;
    private String dsSubGrupoProduto;
    private GrupoProduto grupoProduto;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @GeneratedValue
    @Column(name="CD_SUBGRUPO_PRODUTO")
    public Long getCdSubGrupoProduto() {
        return cdSubGrupoProduto;
    }
    public void setCdSubGrupoProduto(Long cdSubGrupoProduto) {
        this.cdSubGrupoProduto = cdSubGrupoProduto;
    }

    @NotNull
    @Size(max = 300)
    @Column(name="DS_SUBGRUPO_PRODUTO", length = 300, nullable = false )
    public String getDsSubGrupoProduto() {
        return dsSubGrupoProduto;
    }
    public void setDsSubGrupoProduto(String dsSubGrupoProduto) {
        this.dsSubGrupoProduto = dsSubGrupoProduto;
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
    
    @JoinColumn(name = "CD_GRUPO_PRODUTO", referencedColumnName = "CD_GRUPO_PRODUTO", nullable = false)
    @ManyToOne(optional = false)
    public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}
	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdSubGrupoProduto == null) ? 0 : cdSubGrupoProduto.hashCode());
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
        SubGrupoProduto other = (SubGrupoProduto) obj;
        if (cdSubGrupoProduto == null) {
            if (other.cdSubGrupoProduto != null)
                return false;
        } else if (!cdSubGrupoProduto.equals(other.cdSubGrupoProduto))
            return false;
        return true;
    }

}
