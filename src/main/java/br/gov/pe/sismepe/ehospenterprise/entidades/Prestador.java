/**
 * Classe Prestador.java
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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "prestador")
public class Prestador implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdPrestador;
    private Pessoa pessoa;
    private String nmMnemonico;
    private Conselho conselho;
    private String nrConselho;
    private String snCorpoClinico;
    private EnumSimNao snAtivo = EnumSimNao.S;

    @Id
    @GeneratedValue
    @Column(name="CD_PRESTADOR")
    public Long getCdPrestador() {
        return cdPrestador;
    }
    public void setCdPrestador(Long cdPrestador) {
        this.cdPrestador = cdPrestador;
    }

    @ManyToOne
    @JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA", nullable = false)
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Size(max = 100)
    @Column(name="NM_MNEMONICO", length = 100)
    public String getNmMnemonico() {
        return nmMnemonico;
    }
    public void setNmMnemonico(String nmMnemonico) {
        this.nmMnemonico = nmMnemonico;
    }

    @ManyToOne
    @JoinColumn(name = "CD_CONSELHO", referencedColumnName = "CD_CONSELHO", nullable = false)
    public Conselho getConselho() {
        return conselho;
    }
    public void setConselho(Conselho conselho) {
        this.conselho = conselho;
    }

    @Size(max = 45)
    @Column(name="NR_CONSELHO", length = 45)
    public String getNrConselho() {
        return nrConselho;
    }
    public void setNrConselho(String nrConselho) {
        this.nrConselho = nrConselho;
    }

    @NotNull
    @NotBlank
    @Size(max = 1)
    @Column(name="SN_CORPO_CLINICO", length = 1, nullable = false )
    public String getSnCorpoClinico() {
        return snCorpoClinico;
    }
    public void setSnCorpoClinico(String snCorpoClinico) {
        this.snCorpoClinico = snCorpoClinico;
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
        result = prime * result + ((cdPrestador == null) ? 0 : cdPrestador.hashCode());
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
        Prestador other = (Prestador) obj;
        if (cdPrestador == null) {
            if (other.cdPrestador != null)
                return false;
        } else if (!cdPrestador.equals(other.cdPrestador))
            return false;
        return true;
    }

}
