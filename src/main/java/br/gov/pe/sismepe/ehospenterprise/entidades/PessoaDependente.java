/**
 * Classe PessoaDependente.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */
package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "pessoa_dependente")
public class PessoaDependente implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
    protected PessoaDependentePK pessoaDependentePK;

	private Long cdParentesco;
    private EnumSimNao snDepSalarioFamilia = EnumSimNao.S;
    private EnumSimNao snDepImpostoRenda = EnumSimNao.S;
    private EnumSimNao snDepEconomicamente = EnumSimNao.S;
    private EnumSimNao snTrabalha = EnumSimNao.S;
    private EnumSimNao snInvalido = EnumSimNao.S;
    private EnumSimNao snAtestadoVacina = EnumSimNao.S;
    private EnumSimNao snAuxilioCreche = EnumSimNao.S;
    private Long cdDocConcessao;
    private Date dtConcessao;
    private Long cdDocCancelamento;
    private Date dtCancelamento;
    private String tpSituacao;
    private Date dtBloqueio;
    private Date dtCadastro;
    private Date dtUltimaAtualizacao;
    private Long cdOperador;
    private Long tpTabela;
    private Long cdMotivoDoBloqueio;
    private Long nrMatriculaAux;
    private Date dtApresEscolaridade;
    private Long nrDiasValidadeEscolaridade;
    private EnumSimNao snDepSismepe = EnumSimNao.S;
    private EnumSimNao snImpossibilitado = EnumSimNao.S;
    private String tpImpossibilitacao;
    private String nrConcessao;
    private String nrCancelamento;
    private Long cdMotivoCancelamento;
    private Long cdMotivoBloqueio;
    private Long cdCarencia;

    @JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa cdPessoa;

    public PessoaDependente() {
    }

    public PessoaDependente(PessoaDependentePK pessoaDependentePK) {
        this.pessoaDependentePK = pessoaDependentePK;
    }

    public PessoaDependente(int nrMatricula, int nrSequencial, int cdCorporacao) {
        this.pessoaDependentePK = new PessoaDependentePK(nrMatricula, nrSequencial, cdCorporacao);
    }

    public PessoaDependentePK getPessoaDependentePK() {
        return pessoaDependentePK;
    }

    public void setPessoaDependentePK(PessoaDependentePK pessoaDependentePK) {
        this.pessoaDependentePK = pessoaDependentePK;
    }

    @Column(name = "CD_PARENTESCO")
    public Long getCdParentesco() {
        return cdParentesco;
    }

    public void setCdParentesco(Long cdParentesco) {
        this.cdParentesco = cdParentesco;
    }

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_DEP_SALARIO_FAMILIA", nullable = false, length = 1)
	public EnumSimNao getSnDepSalarioFamilia() {
		return snDepSalarioFamilia;
	}
	public void setSnDepSalarioFamilia(EnumSimNao snDepSalarioFamilia) {
		this.snDepSalarioFamilia = snDepSalarioFamilia;
	}

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_DEP_IMPOSTO_RENDA", nullable = false, length = 1)
	public EnumSimNao getSnDepImpostoRenda() {
		return snDepImpostoRenda;
	}
	public void setSnDepImpostoRenda(EnumSimNao snDepImpostoRenda) {
		this.snDepImpostoRenda = snDepImpostoRenda;
	}

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_DEP_ECONOMICAMENTE", nullable = false, length = 1)
	public EnumSimNao getSnDepEconomicamente() {
		return snDepEconomicamente;
	}
	public void setSnDepEconomicamente(EnumSimNao snDepEconomicamente) {
		this.snDepEconomicamente = snDepEconomicamente;
	}

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_TRABALHA", nullable = false, length = 1)
	public EnumSimNao getSnTrabalha() {
		return snTrabalha;
	}
	public void setSnTrabalha(EnumSimNao snTrabalha) {
		this.snTrabalha = snTrabalha;
	}

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_TRABALHA", nullable = false, length = 1)
	public EnumSimNao getSnInvalido() {
		return snInvalido;
	}
	public void setSnInvalido(EnumSimNao snInvalido) {
		this.snInvalido = snInvalido;
	}

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_TRABALHA", nullable = false, length = 1)
	public EnumSimNao getSnAtestadoVacina() {
		return snAtestadoVacina;
	}
	public void setSnAtestadoVacina(EnumSimNao snAtestadoVacina) {
		this.snAtestadoVacina = snAtestadoVacina;
	}

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_TRABALHA", nullable = false, length = 1)
	public EnumSimNao getSnAuxilioCreche() {
		return snAuxilioCreche;
	}
	public void setSnAuxilioCreche(EnumSimNao snAuxilioCreche) {
		this.snAuxilioCreche = snAuxilioCreche;
	}

	@Column(name = "CD_DOC_CONCESSAO")
    public Long getCdDocConcessao() {
        return cdDocConcessao;
    }
    public void setCdDocConcessao(Long cdDocConcessao) {
        this.cdDocConcessao = cdDocConcessao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CONCESSAO")
    public Date getDtConcessao() {
        return dtConcessao;
    }
    public void setDtConcessao(Date dtConcessao) {
        this.dtConcessao = dtConcessao;
    }

    @Column(name = "CD_DOC_CANCELAMENTO")
    public Long getCdDocCancelamento() {
        return cdDocCancelamento;
    }
    public void setCdDocCancelamento(Long cdDocCancelamento) {
        this.cdDocCancelamento = cdDocCancelamento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CANCELAMENTO")
    public Date getDtCancelamento() {
        return dtCancelamento;
    }
    public void setDtCancelamento(Date dtCancelamento) {
        this.dtCancelamento = dtCancelamento;
    }

    @Size(max = 2)
    @Column(name = "TP_SITUACAO", length = 2)
    public String getTpSituacao() {
        return tpSituacao;
    }
    public void setTpSituacao(String tpSituacao) {
        this.tpSituacao = tpSituacao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_BLOQUEIO")
    public Date getDtBloqueio() {
        return dtBloqueio;
    }
    public void setDtBloqueio(Date dtBloqueio) {
        this.dtBloqueio = dtBloqueio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CADASTRO")
    public Date getDtCadastro() {
        return dtCadastro;
    }
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ULTIMA_ATUALIZACAO")
    public Date getDtUltimaAtualizacao() {
        return dtUltimaAtualizacao;
    }
    public void setDtUltimaAtualizacao(Date dtUltimaAtualizacao) {
        this.dtUltimaAtualizacao = dtUltimaAtualizacao;
    }

    @Column(name = "CD_OPERADOR")
    public Long getCdOperador() {
        return cdOperador;
    }
    public void setCdOperador(Long cdOperador) {
        this.cdOperador = cdOperador;
    }

    @Column(name = "TP_TABELA")
    public Long getTpTabela() {
        return tpTabela;
    }
    public void setTpTabela(Long tpTabela) {
        this.tpTabela = tpTabela;
    }

    @Column(name = "CD_MOTIVO_DO_BLOQUEIO")
    public Long getCdMotivoDoBloqueio() {
        return cdMotivoDoBloqueio;
    }
    public void setCdMotivoDoBloqueio(Long cdMotivoDoBloqueio) {
        this.cdMotivoDoBloqueio = cdMotivoDoBloqueio;
    }

    @Column(name = "NR_MATRICULA_AUX")
    public Long getNrMatriculaAux() {
        return nrMatriculaAux;
    }
    public void setNrMatriculaAux(Long nrMatriculaAux) {
        this.nrMatriculaAux = nrMatriculaAux;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_APRES_ESCOLARIDADE")
    public Date getDtApresEscolaridade() {
        return dtApresEscolaridade;
    }
    public void setDtApresEscolaridade(Date dtApresEscolaridade) {
        this.dtApresEscolaridade = dtApresEscolaridade;
    }

    @Column(name = "NR_DIAS_VALIDADE_ESCOLARIDADE")
    public Long getNrDiasValidadeEscolaridade() {
        return nrDiasValidadeEscolaridade;
    }
    public void setNrDiasValidadeEscolaridade(Long nrDiasValidadeEscolaridade) {
        this.nrDiasValidadeEscolaridade = nrDiasValidadeEscolaridade;
    }

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_TRABALHA", nullable = false, length = 1)
	public EnumSimNao getSnDepSismepe() {
		return snDepSismepe;
	}
	public void setSnDepSismepe(EnumSimNao snDepSismepe) {
		this.snDepSismepe = snDepSismepe;
	}

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SN_TRABALHA", nullable = false, length = 1)
	public EnumSimNao getSnImpossibilitado() {
		return snImpossibilitado;
	}
	public void setSnImpossibilitado(EnumSimNao snImpossibilitado) {
		this.snImpossibilitado = snImpossibilitado;
	}

    @Size(max = 1)
    @Column(name = "TP_IMPOSSIBILITACAO", length = 1)
    public String getTpImpossibilitacao() {
        return tpImpossibilitacao;
    }
    public void setTpImpossibilitacao(String tpImpossibilitacao) {
        this.tpImpossibilitacao = tpImpossibilitacao;
    }

    @Size(max = 15)
    @Column(name = "NR_CONCESSAO", length = 15)
    public String getNrConcessao() {
        return nrConcessao;
    }
    public void setNrConcessao(String nrConcessao) {
        this.nrConcessao = nrConcessao;
    }

    @Size(max = 15)
    @Column(name = "NR_CANCELAMENTO", length = 15)
    public String getNrCancelamento() {
        return nrCancelamento;
    }
    public void setNrCancelamento(String nrCancelamento) {
        this.nrCancelamento = nrCancelamento;
    }

    @Column(name = "CD_MOTIVO_CANCELAMENTO")
    public Long getCdMotivoCancelamento() {
        return cdMotivoCancelamento;
    }
    public void setCdMotivoCancelamento(Long cdMotivoCancelamento) {
        this.cdMotivoCancelamento = cdMotivoCancelamento;
    }

    @Column(name = "CD_MOTIVO_BLOQUEIO")
    public Long getCdMotivoBloqueio() {
        return cdMotivoBloqueio;
    }
    public void setCdMotivoBloqueio(Long cdMotivoBloqueio) {
        this.cdMotivoBloqueio = cdMotivoBloqueio;
    }

    @Column(name = "CD_CARENCIA")
    public Long getCdCarencia() {
        return cdCarencia;
    }
    public void setCdCarencia(Long cdCarencia) {
        this.cdCarencia = cdCarencia;
    }

    public Pessoa getCdPessoa() {
        return cdPessoa;
    }
    public void setCdPessoa(Pessoa cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaDependentePK != null ? pessoaDependentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaDependente)) {
            return false;
        }
        PessoaDependente other = (PessoaDependente) object;
        if ((this.pessoaDependentePK == null && other.pessoaDependentePK != null) || (this.pessoaDependentePK != null && !this.pessoaDependentePK.equals(other.pessoaDependentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.pe.sismepe.ehospenterprise.entidades.PessoaDependente[ pessoaDependentePK=" + pessoaDependentePK + " ]";
    }
    
}
