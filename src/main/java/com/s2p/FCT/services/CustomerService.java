package com.s2p.FCT.services;

import java.util.List;
import java.util.UUID;

import com.s2p.FCT.entity.Customers;
import com.s2p.FCT.model.CustomerModel;



public interface CustomerService {
	
	   Customers createCustomer(Customers customers);
	    CustomerModel getCustomerById(UUID id);
	    List<CustomerModel> getAllCustomers();
	    Customers updateCustomer(UUID id, Customers customers);
	    void deleteCustomer(UUID id);
		CustomerModel logIn(String email, String password);
		Customers updateCustomerAddress(UUID id, Customers updatedCustomer);

}
