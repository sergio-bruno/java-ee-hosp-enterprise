/**
 * Classe Conselho.java
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
@Table(name = "conselho")
public class Conselho implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdConselho;
    private String dsConselho;
    private String dsSigla;
    private String cdUf;
    private TipoConselho tipoConselho;
    private EnumSimNao snAtivo = EnumSimNao.S;
    
    @Id
    @GeneratedValue
    @Column(name="CD_CONSELHO")
    public Long getCdConselho() {
        return cdConselho;
    }
    public void setCdConselho(Long cdConselho) {
        this.cdConselho = cdConselho;
    }

    @NotNull
    @Size(max = 300)
    @Column(name="DS_CONSELHO", length = 300, nullable = false )
    public String getDsConselho() {
        return dsConselho;
    }
    public void setDsConselho(String dsConselho) {
        this.dsConselho = dsConselho;
    }

    @NotNull
    @Size(max = 10)
    @Column(name="DS_SIGLA", length = 10, nullable = false )
    public String getDsSigla() {
        return dsSigla;
    }
    public void setDsSigla(String dsSigla) {
        this.dsSigla = dsSigla;
    }

    @NotNull
    @Size(max = 2)
    @Column(name="CD_UF", length = 2, nullable = false )
    public String getCdUf() {
        return cdUf;
    }
    public void setCdUf(String cdUf) {
        this.cdUf = cdUf;
    }

    @ManyToOne
    @JoinColumn(name = "CD_TIPO_CONSELHO", referencedColumnName = "CD_TIPO_CONSELHO", nullable = false)
    public TipoConselho getTipoConselho() {
        return tipoConselho;
    }
    public void setTipoConselho(TipoConselho tipoConselho) {
        this.tipoConselho = tipoConselho;
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
        result = prime * result + ((cdConselho == null) ? 0 : cdConselho.hashCode());
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
        Conselho other = (Conselho) obj;
        if (cdConselho == null) {
            if (other.cdConselho != null)
                return false;
        } else if (!cdConselho.equals(other.cdConselho))
            return false;
        return true;
    }

}
