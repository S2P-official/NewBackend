package com.s2p.FCT.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2p.FCT.model.requestModel.OrderRequest;
import com.s2p.FCT.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveOrder(@RequestBody OrderRequest request) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(request));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<Object> getAllOrders(){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findAllOrders());
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Object> getAllOrdersByCustomer(@PathVariable UUID customerId){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findByCustomerId(customerId));
	}

}
