package com.squad5.connecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad5.connecto.model.Postagem;


public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByPrestadorServicos(boolean prestador);


}
