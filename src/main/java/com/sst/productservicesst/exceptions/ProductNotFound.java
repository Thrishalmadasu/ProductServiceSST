package com.sst.productservicesst.exceptions;

public class ProductNotFound extends RuntimeException{
    private Long id;
    public ProductNotFound(Long id,String message) {
        super(message);
        this.id = id;
    }
}
