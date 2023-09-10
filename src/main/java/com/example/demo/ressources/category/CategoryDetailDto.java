package com.example.demo.ressources.category;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryDetailDto {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Integer active;
}
