package com.rodrigo.seguranca.servicos;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigo.seguranca.entidade.UsuarioEntidade;
import com.rodrigo.seguranca.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico implements UserDetailsService {
	
	private final UsuarioRepositorio usuarioRepositorio;
	
	public UsuarioServico(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return usuarioRepositorio.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email não Encontrado."));
	}

	@Transactional(readOnly = true)
	public UsuarioEntidade acharPorId(Long id) {
		return usuarioRepositorio.findById(id).orElseThrow(() -> new UsernameNotFoundException("Entidade não Encontrada."));
	}
}
