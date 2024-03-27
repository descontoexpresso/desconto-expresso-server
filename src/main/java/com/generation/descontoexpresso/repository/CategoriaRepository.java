package com.generation.descontoexpresso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.descontoexpresso.model.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findByNomeCategoriaContainingIgnoreCase(@Param("nomeCategoria") String nomeCategoria);
}
