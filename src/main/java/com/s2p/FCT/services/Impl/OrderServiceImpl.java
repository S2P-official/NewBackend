package com.s2p.FCT.services.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2p.FCT.entity.Customers;
import com.s2p.FCT.entity.Inventory;
import com.s2p.FCT.entity.Order;
import com.s2p.FCT.entity.OrderItem;
import com.s2p.FCT.model.CustomerAddress;
import com.s2p.FCT.model.requestModel.OrderItemRequest;
import com.s2p.FCT.model.requestModel.OrderRequest;
import com.s2p.FCT.repositories.CustomerAddressRepo;
import com.s2p.FCT.repositories.CustomersRepository;
import com.s2p.FCT.repositories.InventoryRepository;
import com.s2p.FCT.repositories.OrderRepository;
import com.s2p.FCT.services.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    private final CustomersRepository customerRepository;
    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;
    private final CustomerAddressRepo customerAddressRepo;

    @Autowired
    public OrderServiceImpl(
        CustomersRepository customerRepository,
        OrderRepository orderRepository,
        InventoryRepository inventoryRepository,
        CustomerAddressRepo customerAddressRepo

    ) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
        this.customerAddressRepo=customerAddressRepo;
    }

    @Override
    @Transactional
    public String createOrder(OrderRequest orderRequest) {
        Optional<Customers> customerOpt = customerRepository.findById(orderRequest.getCustomerId());
        Optional<CustomerAddress> customerAddOpt =customerAddressRepo.findById(orderRequest.getAddressId());
        if (customerOpt.isEmpty()) {
            return "Customer not found";
        }
        if (customerAddOpt.isEmpty()) {
            return "Adrress Not Avilable";
        }

        Customers customer = customerOpt.get();
        CustomerAddress customerAddress=customerAddOpt.get();

        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setOrderDate(LocalDateTime.now());
        order.setCustomers(customer);
        order.setStatus("Pending");
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setCustomerAddress(customerAddress);

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRequest item : orderRequest.getItems()) {
            Optional<Inventory> inventoryOpt = inventoryRepository.findById(item.getProductId());
            if (inventoryOpt.isEmpty()) {
                return "Inventory item with ID " + item.getProductId() + " not found";
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setId(UUID.randomUUID());
            orderItem.setInventory(inventoryOpt.get());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setOrder(order);

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        orderRepository.save(order);

        return "Order created successfully";
    }

   @Override
@Transactional
public List<OrderRequest> findAllOrders() {
    List<Order> orders = orderRepository.findAll(); // fetch all orders
    List<OrderRequest> orderRequests = new ArrayList<>();

    for (Order order : orders) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setCustomerId(order.getCustomers().getId());
        orderRequest.setCustomerName(order.getCustomers().getFirstName() + " " + order.getCustomers().getLastName());
        orderRequest.setEmail(order.getCustomers().getEmail());
        orderRequest.setOrderDate(order.getOrderDate().toLocalDate());
        orderRequest.setTotalAmount(order.getTotalAmount());
        // orderRequest.setAddressId(order.getCustomerAddress().getId());
        if (order.getCustomerAddress() != null) {
    orderRequest.setAddressId(order.getCustomerAddress().getId());
}


        List<OrderItemRequest> itemRequests = new ArrayList<>();
        for (OrderItem item : order.getOrderItems()) {
            OrderItemRequest itemRequest = new OrderItemRequest();
            itemRequest.setProductId(item.getInventory().getId());
            itemRequest.setProductName(item.getInventory().getName());
            itemRequest.setQuantity(item.getQuantity());
            itemRequests.add(itemRequest);
        }

        orderRequest.setItems(itemRequests);
        orderRequests.add(orderRequest);
    }

    return orderRequests;
}


 @Override
@Transactional
public List<OrderRequest> findByCustomerId(UUID customerId) {
    List<Order> orders = orderRepository.findByCustomers_Id(customerId); // fetch orders for given customer
    List<OrderRequest> orderRequests = new ArrayList<>();

    for (Order order : orders) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setCustomerId(order.getCustomers().getId());
        orderRequest.setCustomerName(order.getCustomers().getFirstName() + " " + order.getCustomers().getLastName());
        orderRequest.setEmail(order.getCustomers().getEmail());
        orderRequest.setOrderDate(order.getOrderDate().toLocalDate());
        orderRequest.setTotalAmount(order.getTotalAmount());

        if (order.getCustomerAddress() != null) {
            orderRequest.setAddressId(order.getCustomerAddress().getId());
        }

        List<OrderItemRequest> itemRequests = new ArrayList<>();
        for (OrderItem item : order.getOrderItems()) {
            OrderItemRequest itemRequest = new OrderItemRequest();
            itemRequest.setProductId(item.getInventory().getId());
            itemRequest.setProductName(item.getInventory().getName());
            itemRequest.setQuantity(item.getQuantity());
            itemRequests.add(itemRequest);
        }

        orderRequest.setItems(itemRequests);
        orderRequests.add(orderRequest);
    }

    return orderRequests;
}

}
