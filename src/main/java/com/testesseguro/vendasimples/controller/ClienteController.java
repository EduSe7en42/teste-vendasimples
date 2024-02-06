package com.testesseguro.vendasimples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.testesseguro.vendasimples.model.Cliente;
import com.testesseguro.vendasimples.service.ClienteService;

@Controller
@RequestMapping("/v1/api")
public class ClienteController {
	@Autowired
	public ClienteService clienteService;
	
	@GetMapping(path = "/clientes")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> listCliente = clienteService.findAll();
		
		return new ResponseEntity<List<Cliente>>(listCliente, HttpStatus.OK);
	}
	
	@GetMapping(path = "/cliente/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Long id) {
		Cliente cliente;
		
		try {
			cliente = clienteService.findById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					String.format("Cliente com id %d não encontrado.", id));
		}		
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
}
