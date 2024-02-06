package com.testesseguro.vendasimples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testesseguro.vendasimples.model.Cliente;
import com.testesseguro.vendasimples.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	@Autowired
	public ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		Cliente cliente;
		
		try {
			cliente = clienteRepository.findById(id).get();
		} catch (Exception e) {
			throw new EntityNotFoundException();
		}
		
		return cliente;
	}
}
