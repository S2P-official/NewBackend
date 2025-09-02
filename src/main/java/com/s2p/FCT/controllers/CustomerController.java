package com.s2p.FCT.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.s2p.FCT.model.CustomerModel;
import com.s2p.FCT.entity.Customers;
import com.s2p.FCT.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customersService;

  @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Customers customers) {
    	Customers c = customersService.createCustomer(customers);
    	if(c != null) {
    		return new ResponseEntity<>("created Successfully", HttpStatus.CREATED);
    	}else {
    		return new ResponseEntity<>("Failed to create Customer ", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
        
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> get(@PathVariable UUID id) {
        CustomerModel customer = customersService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<CustomerModel> customers = customersService.getAllCustomers();
        if (customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customers found.");
        }
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody Customers updatedCustomer) {
        try {
            Customers customer = customersService.updateCustomer(id, updatedCustomer);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update customer.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        customersService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable UUID id, @RequestBody Customers updatedCustomer) {
        try {
            Customers updated = customersService.updateCustomerAddress(id, updatedCustomer);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update customer address");
        }
    }
}
