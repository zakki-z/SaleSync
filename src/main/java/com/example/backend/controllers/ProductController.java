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
    @GetMapping("getAllProducts")
    public List<ProductModel> getAllProducts() {

        return productService.getAllProducts();
    }
    @PostMapping("addNewProduct")
    public String addNewProduct(ProductModel product) {

        return productService.addNewProduct(product);
    }
    @GetMapping("getProductById/{id}")
    public ProductModel getProductById(@PathVariable Long id) {

        return productService.getProductById(id);
    }
    @PutMapping("updateProduct/{id}")
    public ProductModel updateProduct(@PathVariable Long id, @RequestBody ProductModel product) {
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("deleteProduct/{id}")
    public void deleteProduct(ProductModel product){

        productService.deleteProduct(product.getId());
    }
}