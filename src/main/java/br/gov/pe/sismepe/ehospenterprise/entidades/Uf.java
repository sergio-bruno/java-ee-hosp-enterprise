/**
 * Classe Uf.java
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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "uf")
public class Uf implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cdUf;
    private String dsUf;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @Column(name="CD_UF")
    public String getCdUf() {
        return cdUf;
    }
    public void setCdUf(String cdUf) {
        this.cdUf = cdUf;
    }

    @NotNull
    @NotBlank
    @Size(max = 300)
    @Column(name="DS_UF", length = 300, nullable = false )
    public String getDsUf() {
        return dsUf;
    }
    public void setDsUf(String dsUf) {
        this.dsUf = dsUf;
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
        result = prime * result + ((cdUf == null) ? 0 : cdUf.hashCode());
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
        Uf other = (Uf) obj;
        if (cdUf == null) {
            if (other.cdUf != null)
                return false;
        } else if (!cdUf.equals(other.cdUf))
            return false;
        return true;
    }

}
