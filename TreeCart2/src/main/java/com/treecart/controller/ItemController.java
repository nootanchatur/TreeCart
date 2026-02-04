package com.treecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.treecart.model.Item;
import com.treecart.serviceImpl.serviceHImpl;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private serviceHImpl itemService;
    @GetMapping
    public String status() {
        return "TreeCart API is running";
    }

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {

        if (item.getName() == null || item.getName().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Item name is required");
        }

        if (item.getPrice() <= 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Price must be greater than zero");
        }

        Item savedItem = itemService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable int id) {

        Item item = itemService.getItemById(id);

        if (item == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Item not found with ID: " + id);
        }

        return ResponseEntity.ok(item);
    }
}
