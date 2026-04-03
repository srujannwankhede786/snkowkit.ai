package com.snowkit.productservice.services;

import com.snowkit.productservice.dtos.GetProductDto;
import com.snowkit.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService {

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<GetProductDto> getAllProducts() {
        return null;
    }
}
