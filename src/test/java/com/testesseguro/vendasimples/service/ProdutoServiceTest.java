package com.testesseguro.vendasimples.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.testesseguro.vendasimples.model.ItensPedido;
import com.testesseguro.vendasimples.model.Produto;
import com.testesseguro.vendasimples.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

	@Mock
	ProdutoRepository produtoRepository;

	@InjectMocks
	ProdutoService produtoService;
	
	@Test 
	void shouldReturnAllProduto() {
		Produto produto = new Produto();
		produto.setNome("Caneca");
		produto.setPreco(12.5F);
		produto.setId(1L);
		produto.setItensPedido(List.of(new ItensPedido()));
		List<Produto> listProduto = Collections.singletonList(produto);
		
		when(produtoRepository.findAll()).thenReturn(listProduto);
		
		List<Produto> respostaProduto = produtoService.findAll();
		
		assertEquals(produto, respostaProduto.get(0));
	}
	
	@Test
	void shouldReturnOneProduto() {
		Produto produto = new Produto();
		produto.setNome("Caneca");
		produto.setPreco(12.5F);
		produto.setId(1L);
		produto.setItensPedido(List.of(new ItensPedido()));
		
		when(produtoRepository.findById(anyLong())).thenReturn(Optional.of(produto));
		
		Produto produtoResposta = produtoService.findProdutoById(1L);
		
		assertEquals(produto, produtoResposta);
	}
	
	@Test
	void shouldThrowEntityNotFundExceptionProduto() {
		when(produtoRepository.findById(anyLong())).thenReturn(null);
		
		Executable respostaProduto = () -> produtoService.findProdutoById(anyLong());
		
		assertThrows(EntityNotFoundException.class, respostaProduto);
	}
}
