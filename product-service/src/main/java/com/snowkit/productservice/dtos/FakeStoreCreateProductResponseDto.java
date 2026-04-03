package com.snowkit.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String thumbnail;
    private String description;
    private String category;
}
