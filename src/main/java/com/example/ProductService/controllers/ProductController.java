package com.example.ProductService.controllers;

import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateProductById(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public Product deleteProductById(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }
}
