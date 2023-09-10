package com.example.demo.ressources.product;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class ProductShowDto {
    @NotNull
    private Integer id;

    @NotNull
    private String name;

    private String image;
}
