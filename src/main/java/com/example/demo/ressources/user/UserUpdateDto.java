package com.example.demo.ressources.user;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UserUpdateDto {
    @NotNull
    private Integer id;
    private String benutzername;
    private String passwort;
    private String email;
    private Date geburtstag;
}

