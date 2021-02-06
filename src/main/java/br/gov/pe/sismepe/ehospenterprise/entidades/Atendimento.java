/**
 * Classe Atendimento.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdAtendimento;
    private String tpAtendimento;
    private Paciente paciente;
    private Date dtAbertura;
    private OrigemAtend origemAtend;
    private Especialidade especialidade;
    private Prestador prestador;
    private Long cdUsuarioAbertura;
    private Date dtFinalizacao;
    private Long cdUsuarioFinalizacao;
    private Date dtCancelamento;
    private Long cdUsuarioCancelamento;
    private Long cdSituacaoAtendimento;
    private String dsObservacao;
    private Long nrSenha;
    private AtendimentoIntCred atendimentoIntCred; 

    private List<AtendimentoCid> atendimentoCids = new ArrayList<>();
    private List<AtendimentoIntCredMtv> atendimentoIntCredMtvs = new ArrayList<>();
    
    @Id
    @GeneratedValue
    @Column(name="CD_ATENDIMENTO")
    public Long getCdAtendimento() {
        return cdAtendimento;
    }
    public void setCdAtendimento(Long cdAtendimento) {
        this.cdAtendimento = cdAtendimento;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CD_ATENDIMENTO", referencedColumnName = "CD_ATENDIMENTO", nullable = false)
    public AtendimentoIntCred getAtendimentoIntCred() {
		return atendimentoIntCred;
	}
	public void setAtendimentoIntCred(AtendimentoIntCred atendimentoIntCred) {
		this.atendimentoIntCred = atendimentoIntCred;
	}

	@NotNull
    @NotBlank
    @Size(max = 1)
    @Column(name="TP_ATENDIMENTO", length = 1, nullable = false )
    public String getTpAtendimento() {
        return tpAtendimento;
    }
    public void setTpAtendimento(String tpAtendimento) {
        this.tpAtendimento = tpAtendimento;
    }

    @JoinColumn(name = "CD_PACIENTE", referencedColumnName = "CD_PACIENTE", nullable = false)
    @ManyToOne(optional = false)
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @NotNull
    @NotBlank
    @Temporal(TemporalType.DATE)
    @Column(name="DT_ABERTURA", nullable = false )
    public Date getDtAbertura() {
        return dtAbertura;
    }
    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    @ManyToOne
    @JoinColumn(name = "CD_ORIGEM_ATEND", referencedColumnName = "CD_ORIGEM_ATEND", nullable = false)
    public OrigemAtend getOrigemAtend() {
        return origemAtend;
    }
    public void setOrigemAtend(OrigemAtend origemAtend) {
        this.origemAtend = origemAtend;
    }

    @ManyToOne
    @JoinColumn(name = "CD_ESPECIALIDADE", referencedColumnName = "CD_ESPECIALIDADE", nullable = false)
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @ManyToOne
    @JoinColumn(name = "CD_PRESTADOR", referencedColumnName = "CD_PRESTADOR", nullable = false)
    public Prestador getPrestador() {
        return prestador;
    }
    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    @NotNull
    @NotBlank
    @Column(name="CD_USUARIO_ABERTURA", nullable = false )
    public Long getCdUsuarioAbertura() {
        return cdUsuarioAbertura;
    }
    public void setCdUsuarioAbertura(Long cdUsuarioAbertura) {
        this.cdUsuarioAbertura = cdUsuarioAbertura;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DT_FINALIZACAO")
    public Date getDtFinalizacao() {
        return dtFinalizacao;
    }
    public void setDtFinalizacao(Date dtFinalizacao) {
        this.dtFinalizacao = dtFinalizacao;
    }

    @Column(name="CD_USUARIO_FINALIZACAO")
    public Long getCdUsuarioFinalizacao() {
        return cdUsuarioFinalizacao;
    }
    public void setCdUsuarioFinalizacao(Long cdUsuarioFinalizacao) {
        this.cdUsuarioFinalizacao = cdUsuarioFinalizacao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DT_CANCELAMENTO")
    public Date getDtCancelamento() {
        return dtCancelamento;
    }
    public void setDtCancelamento(Date dtCancelamento) {
        this.dtCancelamento = dtCancelamento;
    }

    @Column(name="CD_USUARIO_CANCELAMENTO")
    public Long getCdUsuarioCancelamento() {
        return cdUsuarioCancelamento;
    }
    public void setCdUsuarioCancelamento(Long cdUsuarioCancelamento) {
        this.cdUsuarioCancelamento = cdUsuarioCancelamento;
    }

    @NotNull
    @NotBlank
    @Column(name="CD_SITUACAO_ATENDIMENTO", nullable = false )
    public Long getCdSituacaoAtendimento() {
        return cdSituacaoAtendimento;
    }
    public void setCdSituacaoAtendimento(Long cdSituacaoAtendimento) {
        this.cdSituacaoAtendimento = cdSituacaoAtendimento;
    }

    @Column(name="DS_OBSERVACAO", columnDefinition = "text")
    public String getDsObservacao() {
        return dsObservacao;
    }
    public void setDsObservacao(String dsObservacao) {
        this.dsObservacao = dsObservacao;
    }

    @Column(name="NR_SENHA")
    public Long getNrSenha() {
        return nrSenha;
    }
    public void setNrSenha(Long nrSenha) {
        this.nrSenha = nrSenha;
    }

	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public List<AtendimentoCid> getAtendimentoCids() {
		return atendimentoCids;
	}

	public void setAtendimentoCids(List<AtendimentoCid> atendimentoCids) {
		this.atendimentoCids = atendimentoCids;
	}
    
	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public List<AtendimentoIntCredMtv> getAtendimentoIntCredMtvs() {
		return atendimentoIntCredMtvs;
	}

	public void setAtendimentoIntCredMtvs(List<AtendimentoIntCredMtv> atendimentoIntCredMtvs) {
		this.atendimentoIntCredMtvs = atendimentoIntCredMtvs;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdAtendimento == null) ? 0 : cdAtendimento.hashCode());
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
        Atendimento other = (Atendimento) obj;
        if (cdAtendimento == null) {
            if (other.cdAtendimento != null)
                return false;
        } else if (!cdAtendimento.equals(other.cdAtendimento))
            return false;
        return true;
    }

}
