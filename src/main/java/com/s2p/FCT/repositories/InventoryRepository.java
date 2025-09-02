package com.s2p.FCT.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.s2p.FCT.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID>{

}
