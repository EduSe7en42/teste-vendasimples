package com.testesseguro.vendasimples.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.function.Executable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.testesseguro.vendasimples.model.Cliente;
import com.testesseguro.vendasimples.model.Pedido;
import com.testesseguro.vendasimples.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
	
	@Mock
	ClienteRepository clienteRepository;

	@InjectMocks
	ClienteService clienteService;
	
	@Test 
	void shouldReturnAllCliente() {
		Cliente cliente = new Cliente();
		cliente.setEmail("email@email.com");
		cliente.setId(1L);
		cliente.setNome("Teste");
		cliente.setPedidos(List.of(new Pedido()));
		List<Cliente> listCliente = Collections.singletonList(cliente);
		
		when(clienteRepository.findAll()).thenReturn(listCliente);
		
		List<Cliente> respostaCliente = clienteService.findAll();
		
		assertEquals(cliente, respostaCliente.get(0));
		
	}
	
	@Test
	void shouldReturnOneCliente() {
		Cliente cliente = new Cliente();
		cliente.setEmail("email@email.com");
		cliente.setId(1L);
		cliente.setNome("Teste");
		cliente.setPedidos(List.of(new Pedido()));
		
		when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));
		
		Cliente respostaCliente = clienteService.findById(1L);
		
		assertEquals(respostaCliente, cliente);
		
	}
	
	@Test
	void shouldThrowEntityNotFundException() {		
		when(clienteRepository.findById(anyLong())).thenReturn(null);
		 
		Executable respostaCliente = () -> clienteService.findById(anyLong());
		
		assertThrows(EntityNotFoundException.class, respostaCliente);
	}

}
