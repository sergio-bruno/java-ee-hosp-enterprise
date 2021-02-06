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
public class PessoaDependentePK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private int nrMatricula;
    private int nrSequencial;
    private int cdCorporacao;

    public PessoaDependentePK() {
    }

    public PessoaDependentePK(int nrMatricula, int nrSequencial, int cdCorporacao) {
        this.nrMatricula = nrMatricula;
        this.nrSequencial = nrSequencial;
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
    @Column(name = "NR_SEQUENCIAL", nullable = false)
    public int getNrSequencial() {
        return nrSequencial;
    }
    public void setNrSequencial(int nrSequencial) {
        this.nrSequencial = nrSequencial;
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
        hash += (int) nrSequencial;
        hash += (int) cdCorporacao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaDependentePK)) {
            return false;
        }
        PessoaDependentePK other = (PessoaDependentePK) object;
        if (this.nrMatricula != other.nrMatricula) {
            return false;
        }
        if (this.nrSequencial != other.nrSequencial) {
            return false;
        }
        if (this.cdCorporacao != other.cdCorporacao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.pe.sismepe.ehospenterprise.entidades.PessoaDependentePK[ nrMatricula=" + nrMatricula + ", nrSequencial=" + nrSequencial + ", cdCorporacao=" + cdCorporacao + " ]";
    }
    
}
