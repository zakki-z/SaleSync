package com.example.backend.services;

import com.example.backend.models.ProductModel;
import com.example.backend.exceptions.ProductNotFoundException;
import com.example.backend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    public ProductModel getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for ID: " + id));
    }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }
    public ProductModel addNewProduct(ProductModel product) {
        return productRepository.save(product);
    }
//    @Transactional
//    public ProductModel updateProduct(Long id, ProductModel updatedProduct) {
//        ProductModel existingProduct = productRepository.findById(id)
//                .orElseThrow(() -> new ProductNotFoundException("Product not found for ID: " + id));
//        existingProduct.setName(updatedProduct.getName());
//        existingProduct.setType(updatedProduct.getType());
//        existingProduct.setItems(updatedProduct.getItems());
//        existingProduct.setPricePerUnit(updatedProduct.getPricePerUnit());
//        existingProduct.setTotalPrice(updatedProduct.getTotalPrice());
//        return productRepository.save(existingProduct);
//    }
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found for ID: " + id);
        }
        productRepository.deleteById(id);
    }
}