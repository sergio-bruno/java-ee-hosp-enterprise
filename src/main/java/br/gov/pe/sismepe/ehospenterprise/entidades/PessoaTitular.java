/**
 * Classe PessoaTitular.java
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
@Table(name = "pessoa_titular")
public class PessoaTitular implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PessoaTitularPK pessoaTitularPK;
    private int nrDigito;
    private Short cdQuadroAcesso;
    private Double vlAntiguidade;
    private String nmGuerraTitular;
    private String nrIdentMilitar;
    private String dsOrgaoExpIdentMilitar;
    private String cdUfIdentMilitar;
    private Date dtExpIdentMilitar;
    private Long cdBanco;
    private String nrAgenciaBanco;
    private String nrContaBanco;
    private String nrDigitoContaBanco;
    private String cdSituacaoServico;
    private Long cdQuadro;
    private Long cdPosto;
    private Long cdFuncao;
    private String cdOmeServico;
    private String cdOmeDisposicao;
    private Long cdCurso;
    private Long cdClube;
    private Date dtInclusao;
    private Double vlMedidaCabeca;
    private Double vlMedidaAltura;
    private Short vlMedidaCamisa;
    private Short vlMedidaCalca;
    private Short vlMedidaSapato;
    private String dsCor;
    private String dsCabelo;
    private String dsOlho;
    private Long cdConcurso;
    private Long tpTabela;
    private Long nrMatriculaInativo;
    private Date dtCancelamento;
    private Date dtCadastro;
    private Date dtUltimaAtualizacao;
    private Long cdOperador;
    private Long nrMatriculaAux;
    private Long nrDigitoAux;
    private Long cdOme;
    private Pessoa cdPessoa;

    public PessoaTitular() {
    }

    public PessoaTitular(PessoaTitularPK pessoaTitularPK) {
        this.pessoaTitularPK = pessoaTitularPK;
    }

    public PessoaTitular(PessoaTitularPK pessoaTitularPK, int nrDigito) {
        this.pessoaTitularPK = pessoaTitularPK;
        this.nrDigito = nrDigito;
    }

    public PessoaTitular(int nrMatricula, int cdCorporacao) {
        this.pessoaTitularPK = new PessoaTitularPK(nrMatricula, cdCorporacao);
    }

    public PessoaTitularPK getPessoaTitularPK() {
        return pessoaTitularPK;
    }

    public void setPessoaTitularPK(PessoaTitularPK pessoaTitularPK) {
        this.pessoaTitularPK = pessoaTitularPK;
    }

    @NotNull
    @Column(name = "NR_DIGITO", nullable = false)
    public int getNrDigito() {
        return nrDigito;
    }
    public void setNrDigito(int nrDigito) {
        this.nrDigito = nrDigito;
    }

    @Column(name = "CD_QUADRO_ACESSO")
    public Short getCdQuadroAcesso() {
        return cdQuadroAcesso;
    }
    public void setCdQuadroAcesso(Short cdQuadroAcesso) {
        this.cdQuadroAcesso = cdQuadroAcesso;
    }

    @Column(name = "VL_ANTIGUIDADE", precision = 22)
    public Double getVlAntiguidade() {
        return vlAntiguidade;
    }
    public void setVlAntiguidade(Double vlAntiguidade) {
        this.vlAntiguidade = vlAntiguidade;
    }

    @Size(max = 60)
    @Column(name = "NM_GUERRA_TITULAR", length = 60)
    public String getNmGuerraTitular() {
        return nmGuerraTitular;
    }
    public void setNmGuerraTitular(String nmGuerraTitular) {
        this.nmGuerraTitular = nmGuerraTitular;
    }

    @Size(max = 12)
    @Column(name = "NR_IDENT_MILITAR", length = 12)
    public String getNrIdentMilitar() {
        return nrIdentMilitar;
    }
    public void setNrIdentMilitar(String nrIdentMilitar) {
        this.nrIdentMilitar = nrIdentMilitar;
    }

    @Size(max = 4)
    @Column(name = "DS_ORGAO_EXP_IDENT_MILITAR", length = 4)
    public String getDsOrgaoExpIdentMilitar() {
        return dsOrgaoExpIdentMilitar;
    }
    public void setDsOrgaoExpIdentMilitar(String dsOrgaoExpIdentMilitar) {
        this.dsOrgaoExpIdentMilitar = dsOrgaoExpIdentMilitar;
    }

    @Size(max = 2)
    @Column(name = "CD_UF_IDENT_MILITAR", length = 2)
    public String getCdUfIdentMilitar() {
        return cdUfIdentMilitar;
    }
    public void setCdUfIdentMilitar(String cdUfIdentMilitar) {
        this.cdUfIdentMilitar = cdUfIdentMilitar;
    }

    @Column(name = "DT_EXP_IDENT_MILITAR")
    @Temporal(TemporalType.DATE)
    public Date getDtExpIdentMilitar() {
        return dtExpIdentMilitar;
    }
    public void setDtExpIdentMilitar(Date dtExpIdentMilitar) {
        this.dtExpIdentMilitar = dtExpIdentMilitar;
    }

    @Column(name = "CD_BANCO")
    public Long getCdBanco() {
        return cdBanco;
    }
    public void setCdBanco(Long cdBanco) {
        this.cdBanco = cdBanco;
    }

    @Size(max = 12)
    @Column(name = "NR_AGENCIA_BANCO", length = 12)
    public String getNrAgenciaBanco() {
        return nrAgenciaBanco;
    }
    public void setNrAgenciaBanco(String nrAgenciaBanco) {
        this.nrAgenciaBanco = nrAgenciaBanco;
    }

    @Size(max = 12)
    @Column(name = "NR_CONTA_BANCO", length = 12)
    public String getNrContaBanco() {
        return nrContaBanco;
    }
    public void setNrContaBanco(String nrContaBanco) {
        this.nrContaBanco = nrContaBanco;
    }

    @Size(max = 2)
    @Column(name = "NR_DIGITO_CONTA_BANCO", length = 2)
    public String getNrDigitoContaBanco() {
        return nrDigitoContaBanco;
    }
    public void setNrDigitoContaBanco(String nrDigitoContaBanco) {
        this.nrDigitoContaBanco = nrDigitoContaBanco;
    }

    @Size(max = 2)
    @Column(name = "CD_SITUACAO_SERVICO", length = 2)
    public String getCdSituacaoServico() {
        return cdSituacaoServico;
    }
    public void setCdSituacaoServico(String cdSituacaoServico) {
        this.cdSituacaoServico = cdSituacaoServico;
    }

    @Column(name = "CD_QUADRO")
    public Long getCdQuadro() {
        return cdQuadro;
    }
    public void setCdQuadro(Long cdQuadro) {
        this.cdQuadro = cdQuadro;
    }

    @Column(name = "CD_POSTO")
    public Long getCdPosto() {
        return cdPosto;
    }
    public void setCdPosto(Long cdPosto) {
        this.cdPosto = cdPosto;
    }

    @Column(name = "CD_FUNCAO")
    public Long getCdFuncao() {
        return cdFuncao;
    }
    public void setCdFuncao(Long cdFuncao) {
        this.cdFuncao = cdFuncao;
    }

    @Size(max = 10)
    @Column(name = "CD_OME_SERVICO", length = 10)
    public String getCdOmeServico() {
        return cdOmeServico;
    }
    public void setCdOmeServico(String cdOmeServico) {
        this.cdOmeServico = cdOmeServico;
    }

    @Size(max = 10)
    @Column(name = "CD_OME_DISPOSICAO", length = 10)
    public String getCdOmeDisposicao() {
        return cdOmeDisposicao;
    }
    public void setCdOmeDisposicao(String cdOmeDisposicao) {
        this.cdOmeDisposicao = cdOmeDisposicao;
    }

    @Column(name = "CD_CURSO")
    public Long getCdCurso() {
        return cdCurso;
    }
    public void setCdCurso(Long cdCurso) {
        this.cdCurso = cdCurso;
    }

    @Column(name = "CD_CLUBE")
    public Long getCdClube() {
        return cdClube;
    }
    public void setCdClube(Long cdClube) {
        this.cdClube = cdClube;
    }

    @Column(name = "DT_INCLUSAO")
    @Temporal(TemporalType.DATE)
    public Date getDtInclusao() {
        return dtInclusao;
    }
    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    @Column(name = "VL_MEDIDA_CABECA", precision = 22)
    public Double getVlMedidaCabeca() {
        return vlMedidaCabeca;
    }
    public void setVlMedidaCabeca(Double vlMedidaCabeca) {
        this.vlMedidaCabeca = vlMedidaCabeca;
    }

    @Column(name = "VL_MEDIDA_ALTURA", precision = 22)
    public Double getVlMedidaAltura() {
        return vlMedidaAltura;
    }
    public void setVlMedidaAltura(Double vlMedidaAltura) {
        this.vlMedidaAltura = vlMedidaAltura;
    }

    @Column(name = "VL_MEDIDA_CAMISA")
    public Short getVlMedidaCamisa() {
        return vlMedidaCamisa;
    }
    public void setVlMedidaCamisa(Short vlMedidaCamisa) {
        this.vlMedidaCamisa = vlMedidaCamisa;
    }

    @Column(name = "VL_MEDIDA_CALCA")
    public Short getVlMedidaCalca() {
        return vlMedidaCalca;
    }
    public void setVlMedidaCalca(Short vlMedidaCalca) {
        this.vlMedidaCalca = vlMedidaCalca;
    }

    @Column(name = "VL_MEDIDA_SAPATO")
    public Short getVlMedidaSapato() {
        return vlMedidaSapato;
    }
    public void setVlMedidaSapato(Short vlMedidaSapato) {
        this.vlMedidaSapato = vlMedidaSapato;
    }

    @Size(max = 10)
    @Column(name = "DS_COR", length = 10)
    public String getDsCor() {
        return dsCor;
    }
    public void setDsCor(String dsCor) {
        this.dsCor = dsCor;
    }

    @Size(max = 10)
    @Column(name = "DS_CABELO", length = 10)
    public String getDsCabelo() {
        return dsCabelo;
    }
    public void setDsCabelo(String dsCabelo) {
        this.dsCabelo = dsCabelo;
    }

    @Size(max = 10)
    @Column(name = "DS_OLHO", length = 10)
    public String getDsOlho() {
        return dsOlho;
    }
    public void setDsOlho(String dsOlho) {
        this.dsOlho = dsOlho;
    }

    @Column(name = "CD_CONCURSO")
    public Long getCdConcurso() {
        return cdConcurso;
    }
    public void setCdConcurso(Long cdConcurso) {
        this.cdConcurso = cdConcurso;
    }

    @Column(name = "TP_TABELA")
    public Long getTpTabela() {
        return tpTabela;
    }
    public void setTpTabela(Long tpTabela) {
        this.tpTabela = tpTabela;
    }

    @Column(name = "NR_MATRICULA_INATIVO")
    public Long getNrMatriculaInativo() {
        return nrMatriculaInativo;
    }
    public void setNrMatriculaInativo(Long nrMatriculaInativo) {
        this.nrMatriculaInativo = nrMatriculaInativo;
    }

    @Column(name = "DT_CANCELAMENTO")
    @Temporal(TemporalType.DATE)
    public Date getDtCancelamento() {
        return dtCancelamento;
    }
    public void setDtCancelamento(Date dtCancelamento) {
        this.dtCancelamento = dtCancelamento;
    }

    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    public Date getDtCadastro() {
        return dtCadastro;
    }
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Column(name = "DT_ULTIMA_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
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

    @Column(name = "NR_MATRICULA_AUX")
    public Long getNrMatriculaAux() {
        return nrMatriculaAux;
    }
    public void setNrMatriculaAux(Long nrMatriculaAux) {
        this.nrMatriculaAux = nrMatriculaAux;
    }

    @Column(name = "NR_DIGITO_AUX")
    public Long getNrDigitoAux() {
        return nrDigitoAux;
    }
    public void setNrDigitoAux(Long nrDigitoAux) {
        this.nrDigitoAux = nrDigitoAux;
    }

    @Column(name = "CD_OME")
    public Long getCdOme() {
        return cdOme;
    }
    public void setCdOme(Long cdOme) {
        this.cdOme = cdOme;
    }

    @JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA", nullable = false)
    @ManyToOne(optional = false)
    public Pessoa getCdPessoa() {
        return cdPessoa;
    }
    public void setCdPessoa(Pessoa cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaTitularPK != null ? pessoaTitularPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaTitular)) {
            return false;
        }
        PessoaTitular other = (PessoaTitular) object;
        if ((this.pessoaTitularPK == null && other.pessoaTitularPK != null) || (this.pessoaTitularPK != null && !this.pessoaTitularPK.equals(other.pessoaTitularPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.pe.sismepe.ehospenterprise.entidades.PessoaTitular[ pessoaTitularPK=" + pessoaTitularPK + " ]";
    }
    
}
