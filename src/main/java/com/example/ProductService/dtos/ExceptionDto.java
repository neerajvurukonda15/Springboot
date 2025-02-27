package com.example.ProductService.dtos;

public class ExceptionDto {
    private String message;
    private String errorType;


    public ExceptionDto(String message, String errorType) {
        this.message = message;
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}
