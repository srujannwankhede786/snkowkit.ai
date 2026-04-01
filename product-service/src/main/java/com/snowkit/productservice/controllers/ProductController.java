package com.snowkit.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @PostMapping("/prodducts/")
    public void createProduct(){

    }

    @GetMapping("/products/")
    public void getAllProducts(){

    }

    @GetMapping("/products/{id}") //{id} is a ```Path Variable```
    public void getSingleProduct(@PathVariable long id) {

    }

    @DeleteMapping("/products/{id}") //{id} is a ```Path Variable```
    public void deleteProduct(@PathVariable long id) {

    }

    @RequestMapping(name = "SRUJAN", value =  "/products")
    public String random_magic(){
        return "Magic";
    }
}
