package com.sst.productservicesst.service;

import com.sst.productservicesst.DTO.FakeStoreProductDTO;
import com.sst.productservicesst.exceptions.ProductNotFound;
import com.sst.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class FakeStoreProductService implements ProductService{
    public ArrayList<Product> getAllProducts(){
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDTO[] fakeStoreProductDTOS=restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        ArrayList<Product> products=new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO:fakeStoreProductDTOS){
            //convert fakestore DTO object to product object
            Product product = new Product();
            product.setId(fakeStoreProductDTO.getId());
            product.setTitle(fakeStoreProductDTO.getTitle());
            product.setPrice(fakeStoreProductDTO.getPrice());
            product.setDescription(fakeStoreProductDTO.getDescription());
            product.setImage(fakeStoreProductDTO.getImage());
            products.add(product);
        }
        return products;
    }
    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        //convert fakestore DTO object to product object

        if (fakeStoreProductDTO == null) {
            throw new ProductNotFound(id,"Not found product with id: " + id);
        }

        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
