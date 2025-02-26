package com.example.ProductService.services;


import com.example.ProductService.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product getProductById(Long id) ;

    List<Product> getAllProducts() ;

    Product deleteProductById(Long id) ;

    Product addProduct(Product product) ;

    void updateProductById() ;
}
