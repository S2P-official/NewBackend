package com.s2p.FCT.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2p.FCT.entity.Customers;
import com.s2p.FCT.model.CustomerModel;

public interface CustomersRepository extends JpaRepository<Customers, UUID>{
	
	public Customers findByEmail(String email);

    public Customers save(CustomerModel existing);

}
