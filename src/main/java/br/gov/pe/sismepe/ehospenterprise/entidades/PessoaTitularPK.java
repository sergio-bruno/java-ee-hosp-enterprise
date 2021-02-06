/**
 * Classe PessoaDependentePK.java
 * Classe da chave primária da entidade PessoaDependente
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */
package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergio
 */
@Embeddable
public class PessoaTitularPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private int nrMatricula;
    private int cdCorporacao;

    public PessoaTitularPK() {
    }

    public PessoaTitularPK(int nrMatricula, int cdCorporacao) {
        this.nrMatricula = nrMatricula;
        this.cdCorporacao = cdCorporacao;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_MATRICULA", nullable = false)
    public int getNrMatricula() {
        return nrMatricula;
    }
    public void setNrMatricula(int nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "CD_CORPORACAO", nullable = false)
    public int getCdCorporacao() {
        return cdCorporacao;
    }
    public void setCdCorporacao(int cdCorporacao) {
        this.cdCorporacao = cdCorporacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nrMatricula;
        hash += (int) cdCorporacao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaTitularPK)) {
            return false;
        }
        PessoaTitularPK other = (PessoaTitularPK) object;
        if (this.nrMatricula != other.nrMatricula) {
            return false;
        }
        if (this.cdCorporacao != other.cdCorporacao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.pe.sismepe.ehospenterprise.entidades.PessoaTitularPK[ nrMatricula=" + nrMatricula + ", cdCorporacao=" + cdCorporacao + " ]";
    }
    
}
