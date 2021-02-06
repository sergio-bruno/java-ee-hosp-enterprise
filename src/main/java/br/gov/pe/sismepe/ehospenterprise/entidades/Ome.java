/**
 * Classe Ome.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ome")
public class Ome implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdOme;
    private Long cdEmpresa;
    private Long cdReferencia;
    private String dsOme;
    private String dsOmeAbrev;
    private String dsCep;
    private String dsLogradouro;
    private String dsBairro;
    private String cdUf;
    private String dsCidade;

    @Id
    @Column(name="CD_OME")
    public Long getCdOme() {
        return cdOme;
    }
    public void setCdOme(Long cdOme) {
        this.cdOme = cdOme;
    }

    @Column(name="CD_EMPRESA", nullable = false )
    public Long getCdEmpresa() {
        return cdEmpresa;
    }
    public void setCdEmpresa(Long cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    @Column(name="CD_REFERENCIA", nullable = false )
    public Long getCdReferencia() {
        return cdReferencia;
    }
    public void setCdReferencia(Long cdReferencia) {
        this.cdReferencia = cdReferencia;
    }

    @NotNull
    @Size(max = 300)
    @Column(name="DS_OME", length = 300, nullable = false )
    public String getDsOme() {
        return dsOme;
    }
    public void setDsOme(String dsOme) {
        this.dsOme = dsOme;
    }

    @NotNull
    @Size(max = 300)
    @Column(name="DS_OME_ABREV", length = 300, nullable = false )
    public String getDsOmeAbrev() {
        return dsOmeAbrev;
    }
    public void setDsOmeAbrev(String dsOmeAbrev) {
        this.dsOmeAbrev = dsOmeAbrev;
    }

    @Size(max = 9)
    @Column(name="DS_CEP", length = 9, nullable = false )
    public String getDsCep() {
        return dsCep;
    }
    public void setDsCep(String dsCep) {
        this.dsCep = dsCep == null ? null : dsCep.replaceAll("\\D", "");
    }

    @Size(max = 300)
    @Column(name="DS_LOGRADOURO", length = 300, nullable = false )
    public String getDsLogradouro() {
        return dsLogradouro;
    }
    public void setDsLogradouro(String dsLogradouro) {
        this.dsLogradouro = dsLogradouro;
    }

    @Size(max = 300)
    @Column(name="DS_BAIRRO", length = 300, nullable = false )
    public String getDsBairro() {
        return dsBairro;
    }
    public void setDsBairro(String dsBairro) {
        this.dsBairro = dsBairro;
    }

    @Size(max = 2)
    @Column(name="CD_UF", length = 2, nullable = false )
    public String getCdUf() {
        return cdUf;
    }
    public void setCdUf(String cdUf) {
        this.cdUf = cdUf;
    }

    @Size(max = 300)
    @Column(name="DS_CIDADE", length = 300, nullable = false )
    public String getDsCidade() {
        return dsCidade;
    }
    public void setDsCidade(String dsCidade) {
        this.dsCidade = dsCidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdOme == null) ? 0 : cdOme.hashCode());
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
        Ome other = (Ome) obj;
        if (cdOme == null) {
            if (other.cdOme != null)
                return false;
        } else if (!cdOme.equals(other.cdOme))
            return false;
        return true;
    }

}
