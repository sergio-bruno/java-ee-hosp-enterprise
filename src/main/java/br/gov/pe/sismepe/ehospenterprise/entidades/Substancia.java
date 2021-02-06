/**
 * Classe Substancia.java
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
@Table(name = "substancia")
public class Substancia implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdSubstancia;
    private String dsSubstancia;
    private String nrCas;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @GeneratedValue
    @Column(name="CD_SUBSTANCIA")
    public Long getCdSubstancia() {
        return cdSubstancia;
    }
    public void setCdSubstancia(Long cdSubstancia) {
        this.cdSubstancia = cdSubstancia;
    }
    
    @NotNull
    @Size(max = 300)
    @Column(name="DS_SUBSTANCIA", length = 300, nullable = false )
    public String getDsSubstancia() {
        return dsSubstancia;
    }
    public void setDsSubstancia(String dsSubstancia) {
        this.dsSubstancia = dsSubstancia;
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

    @NotNull
    @Size(max = 20)
    @Column(name="NR_CAS", length = 20, nullable = false )
    public String getNrCas() {
		return nrCas;
	}
	public void setNrCas(String nrCas) {
		this.nrCas = nrCas;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdSubstancia == null) ? 0 : cdSubstancia.hashCode());
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
        Substancia other = (Substancia) obj;
        if (cdSubstancia == null) {
            if (other.cdSubstancia != null)
                return false;
        } else if (!cdSubstancia.equals(other.cdSubstancia))
            return false;
        return true;
    }

}
