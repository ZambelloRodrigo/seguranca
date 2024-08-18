package com.rodrigo.seguranca.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigo.seguranca.entidade.UsuarioEntidade;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidade, Long> {

	@Transactional(readOnly = true)
	Optional<UsuarioEntidade> findByEmail(String email);
}
