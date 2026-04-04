package com.snowkit.productservice.controllers;

import com.snowkit.productservice.dtos.CreateProductRequestDto;
import com.snowkit.productservice.dtos.CreateProductResponseDto;
import com.snowkit.productservice.dtos.GetProductDto;
import com.snowkit.productservice.models.Product;
import com.snowkit.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Qualifier("fakeStoreProductService")
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product = productService.createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return productList;
    }

    @GetMapping("/{id}") //{id} is a ```Path Variable```
    public String getSingleProduct(@PathVariable long id) {
        return "Here is you product: "+id;
    }

    @DeleteMapping("/{id}") //{id} is a ```Path Variable```
    public void deleteProduct(@PathVariable long id) {

    }

    public void updateProduct(){

    }

    public void replaaceProduct(){

    }

    @RequestMapping(name = "SRUJAN", value =  "/random_magic")
    public String random_magic(){
        return "Magic";
    }
}
