package com.snowkit.productservice.dtos;

import com.snowkit.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String thumbnail;
    private String category;

    public static GetProductDto fromProduct(Product product){
        GetProductDto getProductDto = new GetProductDto();

        getProductDto.setId(product.getId());
        getProductDto.setDescription(product.getDescription());
        getProductDto.setTitle(product.getTitle());
        getProductDto.setPrice(product.getPrice());
        getProductDto.setThumbnail(product.getImageUrl());
        getProductDto.setCategory(product.getCategoryName());

        return getProductDto;
    }


    public static List<GetProductDto> fromProductList(List<Product> productList){
        List<GetProductDto> getProductDtoList = new ArrayList<>();

        for(Product product_i : productList){
            getProductDtoList.add(GetProductDto.fromProduct(product_i));
        }
        return getProductDtoList;
    }
}
