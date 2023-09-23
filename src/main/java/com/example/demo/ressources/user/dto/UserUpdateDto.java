package com.example.demo.ressources.user.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 * Data Transfer Object (DTO) zur Aktualisierung von Benutzerdaten.
 * DTOs werden verwendet, um Daten zwischen verschiedenen Schichten der Anwendung zu transportieren.
 * Diese Klasse enthält Validierungsanmerkungen, um sicherzustellen, dass die notwendigen Daten vorhanden sind.
 */
@Getter
@Setter
public class UserUpdateDto {

    /**
     * Die eindeutige Identifikationsnummer des Benutzers, der aktualisiert werden soll.
     * Dieses Feld ist ein Pflichtfeld, da es zur Identifikation des Benutzers benötigt wird.
     */
    @NotNull(message = "Die ID des Benutzers darf nicht null sein.")
    private Integer id;

    /**
     * Der neue Benutzername des Benutzers.
     * Dieses Feld ist optional und kann null sein, wenn der Benutzername nicht aktualisiert werden soll.
     */
    private String username;

    /**
     * Die neue E-Mail-Adresse des Benutzers.
     * Dieses Feld ist ein Pflichtfeld, da die E-Mail-Adresse zur Kontaktaufnahme benötigt wird.
     */
    @NotNull(message = "Die E-Mail-Adresse darf nicht null sein.")

    private String email;

    /**
     * Das neue Passwort des Benutzers.
     * Dieses Feld ist ein Pflichtfeld, da das Passwort zur Authentifizierung benötigt wird.
     */
    @NotNull(message = "Das Passwort darf nicht null sein.")
    private String password;


    /**
     * Das neue Geburtsdatum des Benutzers.
     * Dieses Feld ist optional und kann null sein, wenn das Geburtsdatum nicht aktualisiert werden soll.
     */
    private Date birthday;
}
