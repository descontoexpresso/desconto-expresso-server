package com.generation.descontoexpresso.repository;

import com.generation.descontoexpresso.model.Categoria;
import com.generation.descontoexpresso.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllByNomeProdutoContainingIgnoreCase(@Param("nomeProduto") String nomeProduto);

    public List<Produto> findByCategoriaId(@Param("categoriaId") Long categoriaId);
}
