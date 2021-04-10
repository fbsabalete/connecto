package com.squad5.connecto.repository;

import com.squad5.connecto.model.ComentarioPostagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioPostagemRepository extends JpaRepository<ComentarioPostagem, Long> {
    public List<ComentarioPostagem> findAllByComentarioContainingIgnoreCase(String comentario);
}

