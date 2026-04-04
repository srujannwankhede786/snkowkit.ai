package com.snowkit.productservice.services;

import com.snowkit.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.snowkit.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.snowkit.productservice.dtos.GetProductDto;
import com.snowkit.productservice.dtos.GetProductResponse;
import com.snowkit.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service("fakeStoreProductService")
@Primary
public class ProductServiceFakeStoreImpl implements ProductService{

    @Autowired
    private RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {

        FakeStoreCreateProductRequestDto requestDto = new FakeStoreCreateProductRequestDto();
        requestDto.setTitle(product.getTitle());
        requestDto.setDescription(product.getDescription());
        requestDto.setPrice(product.getPrice());
        requestDto.setCategoryName(product.getCategoryName());
        requestDto.setImage(product.getImageUrl());


        FakeStoreCreateProductResponseDto responseDto =
                restTemplate.postForObject("https://dummyjson.com/products/add",
                requestDto,
                FakeStoreCreateProductResponseDto.class);

        if(responseDto!=null){
            Product product1 = new Product();
            product1.setId(responseDto.getId());
            product1.setTitle(responseDto.getTitle());
            product1.setDescription(responseDto.getDescription());
            product1.setPrice(responseDto.getPrice());
            product1.setCategoryName(responseDto.getCategory());
            product1.setImageUrl(responseDto.getThumbnail());

            return product1;
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<>();

        GetProductResponse response = restTemplate.getForObject(
                "https://dummyjson.com/products",
                GetProductResponse.class
        );
        if(response!=null && response.getProducts()!=null){
            for (GetProductDto dto : response.getProducts()) {
                productList.add(dto.toProduct());
            }
        }
        return productList;
    }
}
