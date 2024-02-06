package com.testesseguro.vendasimples.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testesseguro.vendasimples.model.Produto;
import com.testesseguro.vendasimples.service.ProdutoService;

@Controller
@RequestMapping("/v1/api")
public class ProdutoController {
	@Autowired
	public ProdutoService produtoService;
	
	@GetMapping(path = "/produtos")
	public ResponseEntity<List<Produto>> getAll() {
		List<Produto> listProduto = produtoService.findAll();
		
		return new ResponseEntity<List<Produto>>(listProduto, HttpStatus.OK);
	}
	
	@GetMapping(path = "/produto/{id}")
	public ResponseEntity<Produto> getById(@PathVariable("id") Long id) {
		Produto produto = produtoService.findProdutoById(id);
		
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
}
