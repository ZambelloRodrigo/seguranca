package com.rodrigo.seguranca.entidade;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_papel")
public class PapelEntidade implements Serializable, GrantedAuthority {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String autoridade;
		
	public PapelEntidade() { }

	public PapelEntidade(Long id, String autoridade) {
		super();
		this.id = id;
		this.autoridade = autoridade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(String autoridade) {
		this.autoridade = autoridade;
	}
	
	@Override
	public String getAuthority() {
		return autoridade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PapelEntidade other = (PapelEntidade) obj;
		return Objects.equals(id, other.id);
	}
}
