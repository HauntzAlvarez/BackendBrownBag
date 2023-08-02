package com.example.Inventory.Inventory;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getItems() {
        return inventoryRepository.findAll();
    }

    public void addNewItem(Inventory inventory) {
        Optional<Inventory> optionalInventory = inventoryRepository.findItemByName(inventory.getProductName());
        if (optionalInventory.isPresent()) {
            throw new IllegalStateException("item already listed");
        }
        inventoryRepository.save(inventory);
    }

    @Transactional
    public void updateItemQty(Long itemId, int newQty) {
        inventoryRepository.findById(itemId)
                .map(inventory -> {
                    inventory.setQty(newQty);
                    return inventoryRepository.save(inventory);
                });
    }

    public void deleteItem(Long itemId) {
        boolean exists = inventoryRepository.existsById(itemId);
        if (exists) {
            inventoryRepository.deleteById(itemId);
        }
        else {
            throw new IllegalStateException("item does not exist");
        }
    }

}
