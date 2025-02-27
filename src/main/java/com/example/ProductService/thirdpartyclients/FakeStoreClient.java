package com.example.ProductService.thirdpartyclients;

import com.example.ProductService.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {

    private final RestTemplate restTemplate;

    @Value("${fakestore.api.url}")
    private String baseUrl;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public FakeStoreProductDto getProductById(Long id) {
        String url = baseUrl + "/products/" + id;
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(url, FakeStoreProductDto.class);
        return response.getBody();
    }
}
