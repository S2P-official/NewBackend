package com.s2p.FCT.services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2p.FCT.entity.Product;
import com.s2p.FCT.repositories.ProductRepository;

@Service
public class ProductServiceImpl {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public boolean existsById(UUID id) {
		return productRepository.existsById(id);
	}

}
