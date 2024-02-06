package com.testesseguro.vendasimples.dto;

public class ItensPedidoDTO {
	private int quantidade;
	private Long produto;
	private Long pedido;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Long getProduto() {
		return produto;
	}
	public void setProduto(Long produto) {
		this.produto = produto;
	}
	public Long getPedido() {
		return pedido;
	} 
	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}
}
