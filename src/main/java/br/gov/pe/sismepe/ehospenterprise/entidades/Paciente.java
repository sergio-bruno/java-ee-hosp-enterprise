/**
 * Classe Paciente.java
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdPaciente;
    private Pessoa pessoa;
    private String nmMae;
    private String dsEndereco;
    private String nrTelefone;
    private String snObito;
    private String cdPacienteDiagnocel;

    @Id
    @GeneratedValue
    @Column(name="CD_PACIENTE")
    public Long getCdPaciente() {
        return cdPaciente;
    }
    public void setCdPaciente(Long cdPaciente) {
        this.cdPaciente = cdPaciente;
    }

    @JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA", nullable = false)
    @OneToOne(optional = false)
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Size(max = 300)
    @Column(name="NM_MAE", length = 300)
    public String getNmMae() {
        return nmMae;
    }
    public void setNmMae(String nmMae) {
        this.nmMae = nmMae;
    }

    @Size(max = 1000)
    @Column(name="DS_ENDERECO", length = 1000)
    public String getDsEndereco() {
        return dsEndereco;
    }
    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    @Size(max = 50)
    @Column(name="NR_TELEFONE", length = 50)
    public String getNrTelefone() {
        return nrTelefone;
    }
    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    @Size(max = 1)
    @Column(name="SN_OBITO", length = 1)
    public String getSnObito() {
        return snObito;
    }
    public void setSnObito(String snObito) {
        this.snObito = snObito;
    }

    @Size(max = 100)
    @Column(name="CD_PACIENTE_DIAGNOCEL", length = 100)
    public String getCdPacienteDiagnocel() {
        return cdPacienteDiagnocel;
    }
    public void setCdPacienteDiagnocel(String cdPacienteDiagnocel) {
        this.cdPacienteDiagnocel = cdPacienteDiagnocel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdPaciente == null) ? 0 : cdPaciente.hashCode());
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
        Paciente other = (Paciente) obj;
        if (cdPaciente == null) {
            if (other.cdPaciente != null)
                return false;
        } else if (!cdPaciente.equals(other.cdPaciente))
            return false;
        return true;
    }

}
