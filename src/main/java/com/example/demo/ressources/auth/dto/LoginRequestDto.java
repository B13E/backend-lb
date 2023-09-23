package com.example.demo.ressources.auth.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO-Klasse für die Login anfragen.
 */
@Getter
@Setter
public class LoginRequestDto {

    /**
     * Die Email Adresse des Benutzers.
     */
    private String email;

    /**
     * Das Passwort des Benutzers.
     */
    private String password;
}
