package com.sst.productservicesst.exceptions;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String message) {
        super(message);
    }
}
