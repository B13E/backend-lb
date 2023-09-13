package com.example.demo.ressources.product.dto;

import com.example.demo.ressources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto {
    @NotNull
    private String sku;
    @NotNull
    private String name;
    private String image;
    private String description;
    @NotNull
    private Float price;
    private Integer stock;
    private Category category;
}
