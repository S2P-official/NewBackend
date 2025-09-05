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

import com.s2p.FCT.entity.Inventory;
import com.s2p.FCT.services.Impl.InventoryServiceImpl;

@CrossOrigin(origins = "*") //This is updated code
@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryServiceImpl inventoryService;

    @Autowired
    private ObjectMapper objectMapper;

    // --- Add Product with Images ---
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(
            @RequestPart("Inventory") String inventoryJson,
            @RequestPart("images") List<MultipartFile> images
    ) {
        try {
            Inventory inventory = objectMapper.readValue(inventoryJson, Inventory.class);
            Inventory saved = inventoryService.saveProductWithImages(inventory, images);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving product: " + e.getMessage());
        }
    }

    // --- Get All Products ---
    @GetMapping("/products")
    public ResponseEntity<List<Inventory>> getAllProducts() {
        List<Inventory> products = inventoryService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // --- Get Product by ID for Checkout ---
    @GetMapping("/checkout/{id}")
    public ResponseEntity<Inventory> getCheckoutProduct(@PathVariable UUID id) {
        Inventory product = inventoryService.getCheckoutProductById(id);
        return ResponseEntity.ok(product);
    }

    // --- Get Uploaded Images for Product ---
    @GetMapping("/uploads/{folderName}")
    public ResponseEntity<List<String>> getImages(@PathVariable String folderName) {
        String baseUploadDir = System.getProperty("user.dir") + "/uploads";
        File folder = new File(baseUploadDir + "/" + folderName);

        if (!folder.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        String baseUrl = "/uploads/" + folderName + "/";
        List<String> imagePaths = Arrays.stream(files)
                .filter(File::isFile)
                .map(file -> baseUrl + file.getName())
                .collect(Collectors.toList());

        return ResponseEntity.ok(imagePaths);
    }
}

