/**
 * Classe Cargo.java
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dsCargo;
    private Long cdCargo;

    @Id
    @GeneratedValue
    @Column(name="CD_CARGO")
    public Long getCdCargo() {
        return cdCargo;
    }
    public void setCdCargo(Long cdCargo) {
        this.cdCargo = cdCargo;
    }
    
    @NotNull
    @Size(max = 300)
    @Column(name="DS_CARGO", length = 300, nullable = false )
    public String getDsCargo() {
        return dsCargo;
    }
    public void setDsCargo(String dsCargo) {
        this.dsCargo = dsCargo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdCargo == null) ? 0 : cdCargo.hashCode());
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
        Cargo other = (Cargo) obj;
        if (cdCargo == null) {
            if (other.cdCargo != null)
                return false;
        } else if (!cdCargo.equals(other.cdCargo))
            return false;
        return true;
    }

}
