package com.testesseguro.vendasimples.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testesseguro.vendasimples.model.Produto;
import com.testesseguro.vendasimples.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		List<Produto> listProduto = produtoRepository.findAll();
		return listProduto;
	}
	
	public Produto findProdutoById(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		
		return produto.get();
	}
}
