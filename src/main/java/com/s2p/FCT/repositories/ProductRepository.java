package com.s2p.FCT.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2p.FCT.entity.Product;

public interface ProductRepository extends JpaRepository<Product,UUID>{
	
	public boolean existsById(UUID id);
}