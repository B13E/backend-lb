package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto {
    private String sku;
    private String name;
    private String image;
    private String description;
    private Float price;
    private Integer stock;
    private Category category;
}
