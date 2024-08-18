package com.rodrigo.seguranca.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.seguranca.controlador.dto.UsuarioDTO;
import com.rodrigo.seguranca.controlador.mapa.UsuarioMapa;
import com.rodrigo.seguranca.entidade.UsuarioEntidade;
import com.rodrigo.seguranca.servicos.UsuarioServico;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

	private final UsuarioServico usuarioServico;
	private final UsuarioMapa usuarioMapa;
	
	public UsuarioControlador(UsuarioServico usuarioServico, UsuarioMapa usuarioMapa) {
		this.usuarioServico = usuarioServico;
		this.usuarioMapa = usuarioMapa;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<UsuarioDTO> acharPorId(@PathVariable Long id) {
		UsuarioEntidade entidade = usuarioServico.acharPorId(id);
		UsuarioDTO dto = usuarioMapa.paraDto(entidade);
		return ResponseEntity.ok().body(dto);
	}
}
