package com.example.warehouse.controller;

import com.example.warehouse.bean.Item;
import com.example.warehouse.server.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // 获取所有商品
    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        try {
            List<Item> items = itemService.findAllItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 创建新商品
    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody Item item) {
        try {
            itemService.addItem(item);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating item: " + e.getMessage());
        }
    }

    // 删除商品
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Integer id) {
        try {
            itemService.deleteItemById(id);
            return ResponseEntity.ok("Item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting item: " + e.getMessage());
        }
    }

    // 更新商品信息
    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Integer id, @RequestBody Item item) {
        try {
            item.setId(id);
            itemService.updateItem(item);
            return ResponseEntity.ok("Item updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating item: " + e.getMessage());
        }
    }
}
