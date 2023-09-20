package com.example.demo.ressources.user.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UserShowDto {
    @NotNull
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String email;
}

