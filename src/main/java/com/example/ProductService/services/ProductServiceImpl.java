package com.example.ProductService.services;

import com.example.ProductService.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SelfProductService")
public class ProductServiceImpl implements ProductService {

    private final List<Product> productList = new ArrayList<>();

    @Override
    public Product getProductById(Long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product deleteProductById(Long id) {
        Product productToDelete = null;
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                productToDelete = product;
                break;
            }
        }
        if (productToDelete != null) {
            productList.remove(productToDelete);
        }
        return productToDelete;
    }

    @Override
    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    @Override
    public Product updateProductById(Long id, Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }
}
