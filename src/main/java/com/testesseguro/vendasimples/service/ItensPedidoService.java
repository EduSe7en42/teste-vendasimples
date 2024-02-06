package com.testesseguro.vendasimples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testesseguro.vendasimples.dto.ItensPedidoDTO;
import com.testesseguro.vendasimples.model.ItensPedido;
import com.testesseguro.vendasimples.model.Pedido;
import com.testesseguro.vendasimples.model.Produto;
import com.testesseguro.vendasimples.repository.ItensPedidoRepository;
import com.testesseguro.vendasimples.repository.PedidoRepository;
import com.testesseguro.vendasimples.repository.ProdutoRepository;

@Service
public class ItensPedidoService {
	@Autowired
	public ItensPedidoRepository itensPedidoRepository;
	
	@Autowired
	public PedidoRepository pedidoRepository;
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	public ItensPedido save(ItensPedidoDTO itensPedidoDTO) {
		Pedido pedido = pedidoRepository.findById(itensPedidoDTO.getPedido()).get();
		Produto produto = produtoRepository.findById(itensPedidoDTO.getProduto()).get();
		
		ItensPedido itensPedido = new ItensPedido();
		itensPedido.setQuantidade(itensPedidoDTO.getQuantidade());
		itensPedido.setPedido(pedido);
		itensPedido.setProduto(produto);
		
		return itensPedidoRepository.save(itensPedido);
	}
	
	public List<ItensPedido> findAllByPedido(Long pedido) {
		return itensPedidoRepository.findAllByPedido(pedido);
	}
}
