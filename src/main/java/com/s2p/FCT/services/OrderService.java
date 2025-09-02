package com.s2p.FCT.services;

import java.util.List;
import java.util.UUID;

import com.s2p.FCT.entity.Order;
import com.s2p.FCT.model.requestModel.OrderRequest;

public interface OrderService {
	
	String createOrder(OrderRequest order);

	// In OrderService interface
	List<OrderRequest> findAllOrders();


	List<OrderRequest> findByCustomerId(UUID customerId);
}
