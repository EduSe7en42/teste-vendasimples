package com.testesseguro.vendasimples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testesseguro.vendasimples.model.Produto;
import com.testesseguro.vendasimples.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		List<Produto> listProduto = produtoRepository.findAll();
		return listProduto;
	}
	
	public Produto findProdutoById(Long id) {
		Produto produto;
		
		try {
			produto = produtoRepository.findById(id).get();
		} catch (Exception e) {
			throw new EntityNotFoundException();
		}
		
		return produto;
	}
}
