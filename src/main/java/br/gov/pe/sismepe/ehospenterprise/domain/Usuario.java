package br.gov.pe.sismepe.ehospenterprise.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.gov.pe.sismepe.ehospenterprise.entidades.Pessoa;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, UserDetails {

	private static final long serialVersionUID = 8854814860558885739L;

	@Id
	@GeneratedValue
	@Column(name="CD_USUARIO")
	private Integer id;

	@Column(name="DS_EMAIL")
	private String nome;
	
	@NotNull
	@Column(name = "NM_LOGIN")
	private String username;
	
	@NotNull
	@Column(name = "DS_SENHA")
	private String password;

	@Column(name = "SN_ATIVO")
	private String enabled;
	
    //@JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA", nullable = false)
    //@ManyToOne(optional = false)
    private Pessoa cdPessoa;
	
	@ManyToMany   
	@JoinTable(name = "perfil_usuario", joinColumns = @JoinColumn(name="CD_USUARIO"),inverseJoinColumns = @JoinColumn(name = "CD_PERFIL"))
	private List<Papel> authorities;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isEnabled() {
		if (this.enabled.equals('S')) {
			return true;
		} else {
			return false;
		}
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return authorities;
	}

	public void setAuthorities(List<Papel> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
