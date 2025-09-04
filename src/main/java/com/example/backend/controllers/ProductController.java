package com.example.backend.controllers;


import com.example.backend.models.ProductModel;
import com.example.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    public ProductService productService;
    @GetMapping
    public List<ProductModel> getAllProducts() {

        return productService.getAllProducts();
    }
    @PostMapping
    public ProductModel createProduct(@RequestBody ProductModel product) {

        return productService.createProduct(product);
    }
    @GetMapping("/{id}")
    public ProductModel getProductById(@PathVariable Long id) {

        return productService.getProductById(id);
    }
//    @PutMapping("/{id}")
//    public ProductModel updateProduct(@PathVariable Long id, @RequestBody ProductModel product) {
//        return productService.updateProduct(id, product);
//    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}