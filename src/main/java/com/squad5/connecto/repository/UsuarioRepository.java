package com.squad5.connecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad5.connecto.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public Optional<Usuario> findByEmailIgnoreCase(String email);
}
