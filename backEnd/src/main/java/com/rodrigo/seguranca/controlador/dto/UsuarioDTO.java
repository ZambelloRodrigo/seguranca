package com.rodrigo.seguranca.controlador.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	
	public UsuarioDTO() { }

	public UsuarioDTO(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
