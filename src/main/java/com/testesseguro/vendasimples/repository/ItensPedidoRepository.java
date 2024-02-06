package com.testesseguro.vendasimples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.testesseguro.vendasimples.model.ItensPedido;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long>{
	@Query("select ip from ItensPedido ip where ip.pedido.id = ?1")
	List<ItensPedido> findAllByPedido(Long idPedido);
}
