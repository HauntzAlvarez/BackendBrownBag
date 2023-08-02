package com.example.Inventory.Inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getItems() {
        return inventoryService.getItems();
    }

    @PostMapping
    public void addNewItem(@RequestBody Inventory inventory) {
        inventoryService.addNewItem(inventory);
    }

    @PutMapping(path = "{itemId}")
    public void updateItemQty(
            @PathVariable("itemId") Long itemId,
            @RequestParam(required = true) int newQty) {
        inventoryService.updateItemQty(itemId, newQty);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        inventoryService.deleteItem(itemId);
    }
}
