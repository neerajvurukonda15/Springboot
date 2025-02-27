package com.example.ProductService.services;

import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;
import com.example.ProductService.thirdpartyclients.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("FakeProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    private final FakeStoreClient fakeStoreClient;

    @Autowired
    public FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        FakeStoreProductDto dto = fakeStoreClient.getProductById(id);
        if (dto == null) {
            throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }
        return convertToProduct(dto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] dtos = fakeStoreClient.getAllProducts();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto dto : dtos) {
            products.add(convertToProduct(dto));
        }
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        FakeStoreProductDto dto = fakeStoreClient.addProduct(convertToDto(product));
        return convertToProduct(dto);
    }

    @Override
    public Product deleteProductById(Long id) throws ProductNotFoundException {
        FakeStoreProductDto dto = fakeStoreClient.deleteProductById(id);
        if (dto == null) {
            throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }
        return convertToProduct(dto);
    }

    @Override
    public Product updateProductById(Long id, Product updatedProduct) throws ProductNotFoundException {
        FakeStoreProductDto dto = fakeStoreClient.updateProductById(id, convertToDto(updatedProduct));
        if (dto == null) {
            throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }
        return convertToProduct(dto);
    }

    private Product convertToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);

        return product;
    }

    private FakeStoreProductDto convertToDto(Product product) {
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategory(product.getCategory().getName());
        return dto;
    }
}
