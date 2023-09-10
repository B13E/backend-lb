package com.example.demo.ressources.category;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryUpdateDto {
    @NotNull
    private Integer id;
    private String name;
}
