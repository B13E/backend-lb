package com.example.demo.ressources.category;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryCreateDto {
    @NotNull
    private String name;
}

