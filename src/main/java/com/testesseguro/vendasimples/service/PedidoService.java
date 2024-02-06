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
		return pedidoRepository.findById(id).get();
	}
	
	public Pedido save(PedidoDTO pedidoDTO) {
		Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente()).get();
		
		Pedido pedido = new Pedido();
		
		pedido.setCliente(cliente);
		pedido.setDataCriacao(LocalDate.now());
		pedido.setStatus(pedidoDTO.getStatus());	
		
		return pedidoRepository.save(pedido);
	}
}
