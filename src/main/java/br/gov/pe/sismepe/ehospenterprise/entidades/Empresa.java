/**
 * Classe Empresa.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdEmpresa;
    private String nmEmpresa;
    private String nmRazaoSocial;
    private String nrCnpj;
    private String nrInscricaoEstadual;
    private String nrInscricaoMunicipal;
    private Endereco endereco;
    private EnumSimNao snAtivo = EnumSimNao.S;
    private EnumTpPessoa tpPessoa = EnumTpPessoa.J;
    private List<UnidadeAtendimento> unidadeAtendimento;
    
	@Id
    @GeneratedValue
    @Column(name="CD_EMPRESA")
    public Long getCdEmpresa() {
        return cdEmpresa;
    }
    public void setCdEmpresa(Long cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    @Size(max = 300)
    @Column(name="NM_EMPRESA", length = 300)
    public String getNmEmpresa() {
        return nmEmpresa;
    }
    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    @Size(max = 300)
    @Column(name="NM_RAZAO_SOCIAL", length = 300)
    public String getNmRazaoSocial() {
        return nmRazaoSocial;
    }
    public void setNmRazaoSocial(String nmRazaoSocial) {
        this.nmRazaoSocial = nmRazaoSocial;
    }

    @Size(max = 18)
    @Column(name="NR_CNPJ", length = 18)
    public String getNrCnpj() {
        return nrCnpj;
    }
    public void setNrCnpj(String nrCnpj) {
        this.nrCnpj = nrCnpj == null ? null : nrCnpj.replaceAll("\\D", "");
    }

    @Size(max = 14)
    @Column(name="NR_INSCRICAO_ESTADUAL", length = 14)
    public String getNrInscricaoEstadual() {
        return nrInscricaoEstadual;
    }
    public void setNrInscricaoEstadual(String nrInscricaoEstadual) {
        this.nrInscricaoEstadual = nrInscricaoEstadual;
    }

    @Size(max = 14)
    @Column(name="NR_INSCRICAO_MUNICIPAL", length = 14)
    public String getNrInscricaoMunicipal() {
        return nrInscricaoMunicipal;
    }
    public void setNrInscricaoMunicipal(String nrInscricaoMunicipal) {
        this.nrInscricaoMunicipal = nrInscricaoMunicipal;
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

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="TP_PESSOA", nullable = false, length = 1)
	public EnumTpPessoa getTpPessoa() {
		return tpPessoa;
	}
	public void setTpPessoa(EnumTpPessoa tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
	public List<UnidadeAtendimento> getUnidadeAtendimento() {
		return unidadeAtendimento;
	}
	public void setUnidadeAtendimento(List<UnidadeAtendimento> unidadeAtendimento) {
		this.unidadeAtendimento = unidadeAtendimento;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdEmpresa == null) ? 0 : cdEmpresa.hashCode());
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
        Empresa other = (Empresa) obj;
        if (cdEmpresa == null) {
            if (other.cdEmpresa != null)
                return false;
        } else if (!cdEmpresa.equals(other.cdEmpresa))
            return false;
        return true;
    }

}
