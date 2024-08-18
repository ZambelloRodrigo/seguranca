package com.rodrigo.seguranca.controlador.mapa;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.rodrigo.seguranca.controlador.dto.UsuarioDTO;
import com.rodrigo.seguranca.entidade.UsuarioEntidade;

@Component
public class UsuarioMapa {
	
	private final ModelMapper mapa;
	
	public UsuarioMapa(ModelMapper mapa) {
		this.mapa = mapa;
	}
	
	public UsuarioDTO paraDto(UsuarioEntidade entidade) {
		return mapa.map(entidade, UsuarioDTO.class);
	}
	
    public UsuarioEntidade paraEntidade(UsuarioDTO dto) {
		return mapa.map(dto, UsuarioEntidade.class);
	}
}
