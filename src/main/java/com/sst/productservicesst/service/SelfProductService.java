package com.sst.productservicesst.service;

import com.sst.productservicesst.Repository.CategoryRepository;
import com.sst.productservicesst.Repository.ProductRepository;
import com.sst.productservicesst.exceptions.CategoryNotFound;
import com.sst.productservicesst.exceptions.ProductNotFound;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFound(id, "Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId()== null) { // save the category
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if (optionalCategory.isEmpty()) {
            //The category that is passed in the input product in invalid.
            throw new CategoryNotFound("Invalid category id passed");
        }

        product1.setCategory(optionalCategory.get());
        return product1;
    }
}