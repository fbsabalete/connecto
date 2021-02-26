package com.squad5.connecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad5.connecto.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema>findAllByCategoriaContainingIgnoreCase(String categoria);
}
