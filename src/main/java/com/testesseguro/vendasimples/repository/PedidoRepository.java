package com.testesseguro.vendasimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testesseguro.vendasimples.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
