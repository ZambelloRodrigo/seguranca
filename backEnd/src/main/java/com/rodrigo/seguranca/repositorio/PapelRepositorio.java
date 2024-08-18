package com.rodrigo.seguranca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.seguranca.entidade.PapelEntidade;

@Repository
public interface PapelRepositorio extends JpaRepository<PapelEntidade, Long> {

}
