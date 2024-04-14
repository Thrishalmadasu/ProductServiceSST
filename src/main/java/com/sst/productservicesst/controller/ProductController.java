package com.sst.productservicesst.controller;

import com.sst.productservicesst.DTO.ExceptionDto;
import com.sst.productservicesst.DTO.FakeStoreProductDTO;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.service.FakeStoreProductService;
import com.sst.productservicesst.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// This controller is capable to host HTTP API's
// localhost:8080/products -> ProductController
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping
    public ArrayList<Product> getProduct(){
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable("id") Long id){


//        ResponseEntity<Product> responseEntity;
//        try{
//           Product product = productService.getProductById(id);
//           responseEntity=new ResponseEntity<>(product, org.springframework.http.HttpStatus.OK);
//            return responseEntity;
//        }
//        catch (RuntimeException e) {
//            ExceptionDto dto = new ExceptionDto();
//            dto.setMessage("Product not found");
//            dto.setResolution("Do nothing");
//            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, org.springframework.http.HttpStatus.NOT_FOUND);
//            System.out.println("Product not found");
//            return response;
//        }

        return productService.getProductById(id);
    }
}
