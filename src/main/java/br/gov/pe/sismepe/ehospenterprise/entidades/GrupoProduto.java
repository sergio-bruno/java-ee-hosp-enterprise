/**
 * Classe GrupoProduto.java
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
@Table(name = "grupo_produto")
public class GrupoProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdGrupoProduto;
    private String dsGrupoProduto;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @GeneratedValue
    @Column(name="CD_GRUPO_PRODUTO")
    public Long getCdGrupoProduto() {
        return cdGrupoProduto;
    }
    public void setCdGrupoProduto(Long cdGrupoProduto) {
        this.cdGrupoProduto = cdGrupoProduto;
    }

    @NotNull
    @Size(max = 300)
    @Column(name="DS_GRUPO_PRODUTO", length = 300, nullable = false )
    public String getDsGrupoProduto() {
        return dsGrupoProduto;
    }
    public void setDsGrupoProduto(String dsGrupoProduto) {
        this.dsGrupoProduto = dsGrupoProduto;
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
        result = prime * result + ((cdGrupoProduto == null) ? 0 : cdGrupoProduto.hashCode());
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
        GrupoProduto other = (GrupoProduto) obj;
        if (cdGrupoProduto == null) {
            if (other.cdGrupoProduto != null)
                return false;
        } else if (!cdGrupoProduto.equals(other.cdGrupoProduto))
            return false;
        return true;
    }

}
