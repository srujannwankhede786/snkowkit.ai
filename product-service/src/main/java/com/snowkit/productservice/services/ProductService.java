package com.snowkit.productservice.services;

import com.snowkit.productservice.dtos.GetProductDto;
import com.snowkit.productservice.models.Product;

import java.util.List;

public interface ProductService {
    // Dtos are not good for service, because Dtos are tied to controllers to work upon the request
    // that's why we use models

    Product createProduct(Product product); //Model

    List<Product> getAllProducts();
}
