package com.testesseguro.vendasimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testesseguro.vendasimples.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
