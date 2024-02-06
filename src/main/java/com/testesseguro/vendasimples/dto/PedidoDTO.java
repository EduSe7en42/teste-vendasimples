package com.testesseguro.vendasimples.dto;

public class PedidoDTO  {
	private String status;
	private Long cliente;

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
