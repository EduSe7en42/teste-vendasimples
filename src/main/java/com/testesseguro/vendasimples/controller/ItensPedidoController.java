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

import com.testesseguro.vendasimples.dto.ItensPedidoDTO;
import com.testesseguro.vendasimples.model.ItensPedido;
import com.testesseguro.vendasimples.service.ItensPedidoService;

@RestController
@RequestMapping("/v1/api")
public class ItensPedidoController {
	@Autowired
	ItensPedidoService itensPedidoService;
	
	@GetMapping(path = "/itens-pedido/{idPedido}")
	public ResponseEntity<List<ItensPedido>> findAll(@PathVariable("idPedido") Long idPedido) {
		List<ItensPedido> listItensPedido;
		
		try {
			listItensPedido = itensPedidoService.findAllByPedido(idPedido);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					String.format("Não foi encontrado nenhum item para o pedido %d especificado.", idPedido));
		}
		
		return new ResponseEntity<List<ItensPedido>>(listItensPedido, HttpStatus.OK);
	}
	
	@PostMapping(path = "/itens-pedido")
	public ItensPedido save(@Valid @RequestBody ItensPedidoDTO itensPedidoDTO) {
		ItensPedido itensPedido;

		try {
			itensPedido = itensPedidoService.save(itensPedidoDTO);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Não foi possível salvar o ítem.");
		}
		
		
		return itensPedido;
	}
}
