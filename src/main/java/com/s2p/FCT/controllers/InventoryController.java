package com.s2p.FCT.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.s2p.FCT.entity.*;
import com.s2p.FCT.services.Impl.InventoryServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class InventoryController {

    @Autowired
    private InventoryServiceImpl inventoryService;

    @Autowired
    private ObjectMapper objectMapper; // Needed to convert JSON string to object

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(
        @RequestPart("Inventory") String inventoryJson, // <-- Accept as String
        @RequestPart("images") List<MultipartFile> images
    ) {
        try {
            // Convert the JSON string to an AddInventory object
        	Inventory inventory = objectMapper.readValue(inventoryJson, Inventory.class);

            // Save to DB
            Inventory saved = inventoryService.saveProductWithImages(inventory, images);
            return ResponseEntity.ok(saved);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving product");
        }
    }
    
    @GetMapping("/products")
    public ResponseEntity<List<Inventory>> getAllProducts() {
        List<Inventory> products = inventoryService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/checkout/{id}")
    public ResponseEntity<Inventory> getCheckoutProduct(@PathVariable UUID id) {
        Inventory product = inventoryService.getCheckoutProductById(id);
        return ResponseEntity.ok(product);
    }

    
    @GetMapping("/uploads/{folderName}")
    public ResponseEntity<List<String>> getImages(@PathVariable String folderName) {
        File folder = new File("/uploads" + "/" + folderName);
        if (!folder.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        String baseUrl = "/uploads/" + folderName + "/";
        List<String> imagePaths = Arrays.stream(folder.listFiles())
            .filter(File::isFile)
            .map(file -> baseUrl + file.getName())
            .collect(Collectors.toList());

        return ResponseEntity.ok(imagePaths);
    }


}
