package com.example.demo.ressources.user.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UserDetailDto {
    @NotNull
    private Integer id;
    @NotNull
    private String benutzername;
    @NotNull
    private String passwort;
    @NotNull
    private String email;
    @NotNull
    private Date geburtstag;
}