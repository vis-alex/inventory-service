package com.alex.vis.inventoryservice.controller;

import com.alex.vis.inventoryservice.model.Inventory;
import com.alex.vis.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryRestController {
    private final InventoryRepository inventoryRepository;

    @GetMapping("/{scuCode}")
    public Boolean isInStock(@PathVariable String scuCode) {
        System.out.println("In inventory controller");
        Inventory inventory = inventoryRepository.findByScuCode(scuCode)
                .orElseThrow(() -> new RuntimeException("Cannot find product by scu code " + scuCode));

        return inventory.getStock() > 0;
    }
}