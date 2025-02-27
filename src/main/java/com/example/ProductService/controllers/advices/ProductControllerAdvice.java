package com.example.ProductService.controllers.advices;

import com.example.ProductService.dtos.ExceptionDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage(), "Product Not Found");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
