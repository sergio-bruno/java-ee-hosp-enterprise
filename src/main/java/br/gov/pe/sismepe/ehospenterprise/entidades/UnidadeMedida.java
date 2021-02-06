/**
 * Classe UnidadeMedida.java
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
@Table(name = "unidade_medida")
public class UnidadeMedida implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdUnidadeMedida;
    private String dsUnidadeMedida;
    private String dsUnidadeMedidaAbrev;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @GeneratedValue
    @Column(name="CD_UNIDADE_MEDIDA")
    public Long getCdUnidadeMedida() {
        return cdUnidadeMedida;
    }
    public void setCdUnidadeMedida(Long cdUnidadeMedida) {
        this.cdUnidadeMedida = cdUnidadeMedida;
    }

    @NotNull
    @Size(max = 300)
    @Column(name="DS_UNIDADE_MEDIDA", length = 300, nullable = false )
    public String getDsUnidadeMedida() {
        return dsUnidadeMedida;
    }
    public void setDsUnidadeMedida(String dsUnidadeMedida) {
        this.dsUnidadeMedida = dsUnidadeMedida;
    }

    @NotNull
    @Size(max = 10)
    @Column(name="DS_UNIDADE_MEDIDA_ABREV", length = 10, nullable = false )
    public String getDsUnidadeMedidaAbrev() {
        return dsUnidadeMedidaAbrev;
    }
    public void setDsUnidadeMedidaAbrev(String dsUnidadeMedidaAbrev) {
        this.dsUnidadeMedidaAbrev = dsUnidadeMedidaAbrev;
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
        result = prime * result + ((cdUnidadeMedida == null) ? 0 : cdUnidadeMedida.hashCode());
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
        UnidadeMedida other = (UnidadeMedida) obj;
        if (cdUnidadeMedida == null) {
            if (other.cdUnidadeMedida != null)
                return false;
        } else if (!cdUnidadeMedida.equals(other.cdUnidadeMedida))
            return false;
        return true;
    }

}
