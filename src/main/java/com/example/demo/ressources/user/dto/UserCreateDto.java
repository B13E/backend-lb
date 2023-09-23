package com.example.demo.ressources.user.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 * Data Transfer Object (DTO) zur Erstellung eines Benutzers.
 * DTOs werden verwendet, um Daten zwischen Client und Server auszutauschen.
 * Diese Klasse enthält Validierungsanmerkungen, um sicherzustellen, dass die notwendigen Daten vorhanden sind.
 */
@Getter
@Setter
public class UserCreateDto {

    /**
     * Der Benutzername des neuen Benutzers.
     * Dieses Feld ist ein Pflichtfeld, da ein Benutzer ohne Benutzernamen nicht erstellt werden kann.
     */
    @NotNull(message = "Der Benutzername darf nicht null sein.")
    private String username;

    /**
     * Das Passwort des neuen Benutzers.
     * Dieses Feld ist ein Pflichtfeld, da ein Benutzer ohne Passwort nicht erstellt werden kann.
     */
    @NotNull(message = "Das Passwort darf nicht null sein.")
    private String password;

    /**
     * Die E-Mail-Adresse des neuen Benutzers.
     * Dieses Feld ist ein Pflichtfeld, da die E-Mail-Adresse zur Kontaktaufnahme benötigt wird.
     */
    @NotNull(message = "Die E-Mail-Adresse darf nicht null sein.")
    private String email;

    /**
     * Das Geburtsdatum des neuen Benutzers.
     * Dieses Feld ist ein Pflichtfeld, um das Alter des Benutzers zu ermitteln oder für andere Zwecke.
     */
    @NotNull(message = "Das Geburtsdatum darf nicht null sein.")
    private Date birthday;
}
