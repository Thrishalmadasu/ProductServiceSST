package com.sst.productservicesst.service;

import com.sst.productservicesst.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getAllProducts();
    Product getProductById(Long id);

    Product createProduct(Product product);
}
