package com.redsocial.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redsocial.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}
