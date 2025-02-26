package com.example.ProductService.controller.advices;

import com.example.ProductService.controller.ProductController;
import com.example.ProductService.dtos.ExcpetionDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//@ControllerAdvice(assignableTypes = {ProductController.class})
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<ExcpetionDto> handleProductNotFoundException(ProductNotFoundException e) {
        ExcpetionDto excpetionDto = new ExcpetionDto();
        excpetionDto.setMessage(e.getMessage());
        excpetionDto.setStatus("Failure");
        ResponseEntity<ExcpetionDto> responseEntity = new ResponseEntity<>(excpetionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}