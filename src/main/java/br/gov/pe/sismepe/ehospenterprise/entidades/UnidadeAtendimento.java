/**
 * Classe UnidadeAtendimento.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "unidade_atendimento")
public class UnidadeAtendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdUnidadeAtendimento;
    private String dsUnidadeAtendimento;
    private Endereco endereco;
    private EnumSimNao snAtivo = EnumSimNao.S;
    private Empresa empresa;
	
	@Id
    @GeneratedValue
    @Column(name="CD_UNIDADE_ATENDIMENTO")
    public Long getCdUnidadeAtendimento() {
        return cdUnidadeAtendimento;
    }
    public void setCdUnidadeAtendimento(Long cdUnidadeAtendimento) {
        this.cdUnidadeAtendimento = cdUnidadeAtendimento;
    }

    @Size(max = 300)
    @Column(name="DS_UNIDADE_ATENDIMENTO", length = 300)
    public String getDsUnidadeAtendimento() {
        return dsUnidadeAtendimento;
    }
    public void setDsUnidadeAtendimento(String dsUnidadeAtendimento) {
        this.dsUnidadeAtendimento = dsUnidadeAtendimento;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CD_ENDERECO", referencedColumnName = "CD_ENDERECO", nullable = false)
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
    
    @ManyToOne
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdUnidadeAtendimento == null) ? 0 : cdUnidadeAtendimento.hashCode());
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
        UnidadeAtendimento other = (UnidadeAtendimento) obj;
        if (cdUnidadeAtendimento == null) {
            if (other.cdUnidadeAtendimento != null)
                return false;
        } else if (!cdUnidadeAtendimento.equals(other.cdUnidadeAtendimento))
            return false;
        return true;
    }

}
