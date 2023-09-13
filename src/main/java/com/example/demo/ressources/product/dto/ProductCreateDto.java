package com.example.demo.ressources.product.dto;

import com.example.demo.ressources.category.Category;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
public class ProductCreateDto {
    @NotNull
    private String sku;

    @NotNull
    private String name;

    @NotNull
    private String image;

    @NotNull
    private String description;

    private Float price;

    @NotNull
    private Integer stock;

    private Category category;
}
