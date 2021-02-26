package com.squad5.connecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad5.connecto.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
