/**
 * Classe Pessoa.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdPessoa;
    private String nmPessoa;
    private Date dtNascimento;
    private EnumSexo tpSexo = EnumSexo.M;
    private String tpSanguineo;
    private String nrRg;
    private String dsOrgaoExpedidorRg;
    private String cdUfRg;
    private Date dtExpedicaoRg;
    private String nrCpf;
    private String nrTituloEleitoral;
    private String nrZonaTituloEleitoral;
    private String nrSecaoTituloEleitoral;
    private String cdUfTituloEleitoral;
    private String nrReservista;
    private String nrSerieReservista;
    private String nrTipoReservista;
    private String nrRmReservista;
    private String nrCategoriaReservista;
    private String nrPisPasep;
    private String nrIpsep;
    private String nrCnh;
    private String cdUfCnh;
    private Date dtValidadeCnh;
    private String tpCategoriaCnh;
    private String nrRegistroCnh;

    private Long cdEstadoCivil;
    private Long cdEscolaridade;
    private Long cdReligiao;
    
    private Long cdEndereco;
    private String nrTelefone1;
    private String nrTelefone2;
    private String nmPai;
    private String nmMae;
    private String nmConjuge;
    private String dsNaturalidade;
    
    private String cdUfNaturalidade;

    private String dsNacionalidade;
    private String dsEmail;
    private Date dtCadastro;
    private Long cdUsuarioCadastro;
    private EnumSimNao snAtivo = EnumSimNao.S;
    
    @Id
    @GeneratedValue
    @Column(name="CD_PESSOA")
    public Long getCdPessoa() {
        return cdPessoa;
    }
    public void setCdPessoa(Long cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    @NotNull
    @NotBlank
    @Size(max = 300)
    @Column(name="NM_PESSOA", length = 300, nullable = false )
    public String getNmPessoa() {
        return nmPessoa;
    }
    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DT_NASCIMENTO")
    public Date getDtNascimento() {
        return dtNascimento;
    }
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="TP_SEXO", nullable = false, length = 1)
	public EnumSexo getTpSexo() {
		return tpSexo;
	}
	public void setTpSexo(EnumSexo tpSexo) {
		this.tpSexo = tpSexo;
	}
    
    @Size(max = 3)
    @Column(name="TP_SANGUINEO", length = 3)
    public String getTpSanguineo() {
        return tpSanguineo;
    }
    public void setTpSanguineo(String tpSanguineo) {
        this.tpSanguineo = tpSanguineo;
    }

    @Size(max = 12)
    @Column(name="NR_RG", length = 12)
    public String getNrRg() {
        return nrRg;
    }
    public void setNrRg(String nrRg) {
        this.nrRg = nrRg;
    }

    @Size(max = 4)
    @Column(name="DS_ORGAO_EXPEDIDOR_RG", length = 4)
    public String getDsOrgaoExpedidorRg() {
        return dsOrgaoExpedidorRg;
    }
    public void setDsOrgaoExpedidorRg(String dsOrgaoExpedidorRg) {
        this.dsOrgaoExpedidorRg = dsOrgaoExpedidorRg;
    }

    @Size(max = 2)
    @Column(name="CD_UF_RG", length = 2)
    public String getCdUfRg() {
        return cdUfRg;
    }
    public void setCdUfRg(String cdUfRg) {
        this.cdUfRg = cdUfRg;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_EXPEDICAO_RG")
    public Date getDtExpedicaoRg() {
        return dtExpedicaoRg;
    }
    public void setDtExpedicaoRg(Date dtExpedicaoRg) {
        this.dtExpedicaoRg = dtExpedicaoRg;
    }

    @Size(max = 14)
    @Column(name="NR_CPF", length = 14)
    public String getNrCpf() {
        return nrCpf;
    }
    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    @Size(max = 16)
    @Column(name="NR_TITULO_ELEITORAL", length = 16)
    public String getNrTituloEleitoral() {
        return nrTituloEleitoral;
    }
    public void setNrTituloEleitoral(String nrTituloEleitoral) {
        this.nrTituloEleitoral = nrTituloEleitoral;
    }

    @Size(max = 3)
    @Column(name="NR_ZONA_TITULO_ELEITORAL", length = 3)
    public String getNrZonaTituloEleitoral() {
        return nrZonaTituloEleitoral;
    }
    public void setNrZonaTituloEleitoral(String nrZonaTituloEleitoral) {
        this.nrZonaTituloEleitoral = nrZonaTituloEleitoral;
    }

    @Size(max = 3)
    @Column(name="NR_SECAO_TITULO_ELEITORAL", length = 3)
    public String getNrSecaoTituloEleitoral() {
        return nrSecaoTituloEleitoral;
    }
    public void setNrSecaoTituloEleitoral(String nrSecaoTituloEleitoral) {
        this.nrSecaoTituloEleitoral = nrSecaoTituloEleitoral;
    }

    @Size(max = 2)
    @Column(name="CD_UF_TITULO_ELEITORAL", length = 2)
    public String getCdUfTituloEleitoral() {
        return cdUfTituloEleitoral;
    }
    public void setCdUfTituloEleitoral(String cdUfTituloEleitoral) {
        this.cdUfTituloEleitoral = cdUfTituloEleitoral;
    }

    @Size(max = 16)
    @Column(name="NR_RESERVISTA", length = 16)
    public String getNrReservista() {
        return nrReservista;
    }
    public void setNrReservista(String nrReservista) {
        this.nrReservista = nrReservista;
    }

    @Size(max = 1)
    @Column(name="NR_SERIE_RESERVISTA", length = 1)
    public String getNrSerieReservista() {
        return nrSerieReservista;
    }
    public void setNrSerieReservista(String nrSerieReservista) {
        this.nrSerieReservista = nrSerieReservista;
    }

    @Size(max = 2)
    @Column(name="NR_TIPO_RESERVISTA", length = 2)
    public String getNrTipoReservista() {
        return nrTipoReservista;
    }
    public void setNrTipoReservista(String nrTipoReservista) {
        this.nrTipoReservista = nrTipoReservista;
    }

    @Size(max = 2)
    @Column(name="NR_RM_RESERVISTA", length = 2)
    public String getNrRmReservista() {
        return nrRmReservista;
    }
    public void setNrRmReservista(String nrRmReservista) {
        this.nrRmReservista = nrRmReservista;
    }

    @Size(max = 1)
    @Column(name="NR_CATEGORIA_RESERVISTA", length = 1)
    public String getNrCategoriaReservista() {
        return nrCategoriaReservista;
    }
    public void setNrCategoriaReservista(String nrCategoriaReservista) {
        this.nrCategoriaReservista = nrCategoriaReservista;
    }

    @Size(max = 11)
    @Column(name="NR_PIS_PASEP", length = 11)
    public String getNrPisPasep() {
        return nrPisPasep;
    }
    public void setNrPisPasep(String nrPisPasep) {
        this.nrPisPasep = nrPisPasep;
    }

    @Size(max = 9)
    @Column(name="NR_IPSEP", length = 9)
    public String getNrIpsep() {
        return nrIpsep;
    }
    public void setNrIpsep(String nrIpsep) {
        this.nrIpsep = nrIpsep;
    }

    @Size(max = 12)
    @Column(name="NR_CNH", length = 12)
    public String getNrCnh() {
        return nrCnh;
    }
    public void setNrCnh(String nrCnh) {
        this.nrCnh = nrCnh;
    }

    @Size(max = 2)
    @Column(name="CD_UF_CNH", length = 2)
    public String getCdUfCnh() {
        return cdUfCnh;
    }
    public void setCdUfCnh(String cdUfCnh) {
        this.cdUfCnh = cdUfCnh;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_VALIDADE_CNH")
    public Date getDtValidadeCnh() {
        return dtValidadeCnh;
    }
    public void setDtValidadeCnh(Date dtValidadeCnh) {
        this.dtValidadeCnh = dtValidadeCnh;
    }

    @Size(max = 3)
    @Column(name="TP_CATEGORIA_CNH", length = 3)
    public String getTpCategoriaCnh() {
        return tpCategoriaCnh;
    }
    public void setTpCategoriaCnh(String tpCategoriaCnh) {
        this.tpCategoriaCnh = tpCategoriaCnh;
    }

    @Size(max = 9)
    @Column(name="NR_REGISTRO_CNH", length = 9)
    public String getNrRegistroCnh() {
        return nrRegistroCnh;
    }
    public void setNrRegistroCnh(String nrRegistroCnh) {
        this.nrRegistroCnh = nrRegistroCnh;
    }

    @Column(name="CD_ESTADO_CIVIL")
    public Long getCdEstadoCivil() {
        return cdEstadoCivil;
    }
    public void setCdEstadoCivil(Long cdEstadoCivil) {
        this.cdEstadoCivil = cdEstadoCivil;
    }

    @Column(name="CD_ESCOLARIDADE")
    public Long getCdEscolaridade() {
        return cdEscolaridade;
    }
    public void setCdEscolaridade(Long cdEscolaridade) {
        this.cdEscolaridade = cdEscolaridade;
    }

    @Column(name="CD_RELIGIAO")
    public Long getCdReligiao() {
        return cdReligiao;
    }
    public void setCdReligiao(Long cdReligiao) {
        this.cdReligiao = cdReligiao;
    }

    @Column(name="CD_ENDERECO")
    public Long getCdEndereco() {
        return cdEndereco;
    }
    public void setCdEndereco(Long cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    @Size(max = 30)
    @Column(name="NR_TELEFONE1", length = 30)
    public String getNrTelefone1() {
        return nrTelefone1;
    }
    public void setNrTelefone1(String nrTelefone1) {
        this.nrTelefone1 = nrTelefone1;
    }

    @Size(max = 30)
    @Column(name="NR_TELEFONE2", length = 30)
    public String getNrTelefone2() {
        return nrTelefone2;
    }
    public void setNrTelefone2(String nrTelefone2) {
        this.nrTelefone2 = nrTelefone2;
    }

    @Size(max = 300)
    @Column(name="NM_PAI", length = 300)
    public String getNmPai() {
        return nmPai;
    }
    public void setNmPai(String nmPai) {
        this.nmPai = nmPai;
    }

    @Size(max = 300)
    @Column(name="NM_MAE", length = 300)
    public String getNmMae() {
        return nmMae;
    }
    public void setNmMae(String nmMae) {
        this.nmMae = nmMae;
    }

    @Size(max = 300)
    @Column(name="NM_CONJUGE", length = 300)
    public String getNmConjuge() {
        return nmConjuge;
    }
    public void setNmConjuge(String nmConjuge) {
        this.nmConjuge = nmConjuge;
    }

    @Size(max = 300)
    @Column(name="DS_NATURALIDADE", length = 300)
    public String getDsNaturalidade() {
        return dsNaturalidade;
    }
    public void setDsNaturalidade(String dsNaturalidade) {
        this.dsNaturalidade = dsNaturalidade;
    }

    @Size(max = 2)
    @Column(name="CD_UF_NATURALIDADE", length = 2)
    public String getCdUfNaturalidade() {
        return cdUfNaturalidade;
    }
    public void setCdUfNaturalidade(String cdUfNaturalidade) {
        this.cdUfNaturalidade = cdUfNaturalidade;
    }

    @Size(max = 300)
    @Column(name="DS_NACIONALIDADE", length = 300)
    public String getDsNacionalidade() {
        return dsNacionalidade;
    }
    public void setDsNacionalidade(String dsNacionalidade) {
        this.dsNacionalidade = dsNacionalidade;
    }

    @Size(max = 100)
    @Column(name="DS_EMAIL", length = 100)
    public String getDsEmail() {
        return dsEmail;
    }
    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    @NotNull
    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_CADASTRO", nullable = false )
    public Date getDtCadastro() {
        return dtCadastro;
    }
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Column(name="CD_USUARIO_CADASTRO")
    public Long getCdUsuarioCadastro() {
        return cdUsuarioCadastro;
    }
    public void setCdUsuarioCadastro(Long cdUsuarioCadastro) {
        this.cdUsuarioCadastro = cdUsuarioCadastro;
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
        result = prime * result + ((cdPessoa == null) ? 0 : cdPessoa.hashCode());
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
        Pessoa other = (Pessoa) obj;
        if (cdPessoa == null) {
            if (other.cdPessoa != null)
                return false;
        } else if (!cdPessoa.equals(other.cdPessoa))
            return false;
        return true;
    }

}
