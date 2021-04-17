package com.squad5.connecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squad5.connecto.model.CurtirPostagem;

@Repository
public interface CurtirPostagemRepository extends JpaRepository<CurtirPostagem, Long>{
	
}
