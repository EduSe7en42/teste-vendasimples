package com.testesseguro.vendasimples.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.testesseguro.vendasimples.dto.PedidoDTO;
import com.testesseguro.vendasimples.model.Pedido;
import com.testesseguro.vendasimples.service.ClienteService;
import com.testesseguro.vendasimples.service.PedidoService;

@RestController
@RequestMapping("/v1/api")
public class PedidoController {
	@Autowired
	public PedidoService pedidoService;
	
	@Autowired
	public ClienteService clienteService;
	
	@GetMapping(path = "/pedidos")
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> listPedido = pedidoService.findAll();
		
		if (listPedido.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum pedido foi encontrado.");
		}
		
		return new ResponseEntity<List<Pedido>>(listPedido, HttpStatus.OK);
	}
	
	@GetMapping(path = "/pedido/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable("id") Long id) {
		Pedido pedido;
		
		try {
			pedido = pedidoService.findById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					String.format("Pedido com id %d não encontrado.", id));
		}
		
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@PostMapping(path = "/pedido")
	public Pedido save(@Valid @RequestBody PedidoDTO pedidoDTO) {	
		Pedido pedido;
		
		try {
			pedido = pedidoService.save(pedidoDTO);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Não foi possível salvar o pedido");
		}
		
		return pedido;
	}
}
