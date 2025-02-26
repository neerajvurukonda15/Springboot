package com.example.ProductService.controller;


import com.example.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }


    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){
        return "product fetched by id"+id;
    }

    @GetMapping("/")
    public List<String> getAllProducts(){
        return Collections.emptyList();
    }



}



