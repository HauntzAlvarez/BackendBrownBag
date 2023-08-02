package com.example.Inventory.Inventory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository
        extends JpaRepository<Inventory, Long> {

    @Query("SELECT i FROM Inventory i WHERE i.productName = ?1")
    Optional<Inventory> findItemByName(String productName);
}
