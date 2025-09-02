package com.s2p.FCT.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2p.FCT.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

}
