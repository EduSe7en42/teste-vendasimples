package com.testesseguro.vendasimples.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testesseguro.vendasimples.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
