package com.snowkit.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class GetProductResponse {
    private List<GetProductDto> products;
}
