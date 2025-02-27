package com.example.ProductService.services;

import com.example.ProductService.models.Product;
import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProductById(Long id, Product updatedProduct);
    Product deleteProductById(Long id);
}
