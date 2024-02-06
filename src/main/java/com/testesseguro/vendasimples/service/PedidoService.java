package com.testesseguro.vendasimples.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testesseguro.vendasimples.dto.PedidoDTO;
import com.testesseguro.vendasimples.model.Cliente;
import com.testesseguro.vendasimples.model.Pedido;
import com.testesseguro.vendasimples.repository.ClienteRepository;
import com.testesseguro.vendasimples.repository.PedidoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
		Pedido pedido;
		
		try {
			pedido = pedidoRepository.findById(id).get();
		} catch (Exception e) {
			throw new EntityNotFoundException();
		}
		
		return pedido;
	}
	
	public Pedido save(PedidoDTO pedidoDTO) throws Exception {
		Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente()).get();
		
		
		if (cliente.equals(null)) {
			throw new Exception("Cliente não existente.");
		}
		
		if (pedidoDTO.getStatus().isBlank() || pedidoDTO.getStatus().isEmpty()) {
			pedidoDTO.setStatus("pendente");
		}
		
		Pedido pedido = new Pedido();
		
		pedido.setCliente(cliente);
		pedido.setDataCriacao(LocalDate.now());
		pedido.setStatus(pedidoDTO.getStatus());	
		
		try {
			pedidoRepository.save(pedido);
		} catch (Exception e) {
			throw new Exception("Não foi possível salvar o pedido.");
		}
		
		return pedido;
	}
}
