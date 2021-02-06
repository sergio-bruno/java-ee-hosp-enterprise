/**
 * Classe Endereco.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdEndereco;
    private TipoLogradouro tipoLogradouro;
    private String tpLogradouro;
	private String dsLogradouro;
    private Long nrEndereco;
    private String dsComplemento;
    private String nmBairro;
    private Cidade cidade;
    private Uf uf;
    private String nrCep;

    @Id
    @GeneratedValue
    @Column(name="CD_ENDERECO")
    public Long getCdEndereco() {
        return cdEndereco;
    }
    public void setCdEndereco(Long cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    @ManyToOne
    @JoinColumn(name = "CD_TIPO_LOGRADOURO", referencedColumnName = "CD_TIPO_LOGRADOURO", nullable = false)
    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }
    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    @Size(max = 300)
    @Column(name="DS_LOGRADOURO", length = 300)
    public String getDsLogradouro() {
        return dsLogradouro;
    }
    public void setDsLogradouro(String dsLogradouro) {
        this.dsLogradouro = dsLogradouro;
    }

    @Column(name="NR_ENDERECO")
    public Long getNrEndereco() {
        return nrEndereco;
    }
    public void setNrEndereco(Long nrEndereco) {
        this.nrEndereco = nrEndereco;
    }

    @Column(name="TP_LOGRADOURO")
    public String getTpLogradouro() {
		return tpLogradouro;
	}
	public void setTpLogradouro(String tpLogradouro) {
		this.tpLogradouro = tpLogradouro;
	}
    
    @Size(max = 300)
    @Column(name="DS_COMPLEMENTO", length = 300)
    public String getDsComplemento() {
        return dsComplemento;
    }
    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    @Size(max = 300)
    @Column(name="NM_BAIRRO", length = 300)
    public String getNmBairro() {
        return nmBairro;
    }
    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    @ManyToOne
    @JoinColumn(name = "CD_CIDADE", referencedColumnName = "CD_CIDADE", nullable = false)
    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @ManyToOne
    @JoinColumn(name = "CD_UF", referencedColumnName = "CD_UF", nullable = false)
    public Uf getUf() {
        return uf;
    }
    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @Size(max = 10)
    @Column(name="NR_CEP", length = 8)
    public String getNrCep() {
        return nrCep;
    }
    public void setNrCep(String nrCep) {
        this.nrCep = nrCep == null ? null : nrCep.replaceAll("\\D", "");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdEndereco == null) ? 0 : cdEndereco.hashCode());
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
        Endereco other = (Endereco) obj;
        if (cdEndereco == null) {
            if (other.cdEndereco != null)
                return false;
        } else if (!cdEndereco.equals(other.cdEndereco))
            return false;
        return true;
    }

}
