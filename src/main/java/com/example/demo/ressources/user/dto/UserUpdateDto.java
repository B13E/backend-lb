package com.example.demo.ressources.user.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UserUpdateDto {
    @NotNull
    private Integer id;
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private Date birthday;
}

