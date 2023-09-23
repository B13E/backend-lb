package com.example.demo.ressources.user.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) zur Darstellung von Benutzerdaten in einer vereinfachten Ansicht.
 * DTOs werden verwendet, um Daten zwischen verschiedenen Schichten der Anwendung zu transportieren.
 * Diese Klasse enthält Validierungsanmerkungen, um sicherzustellen, dass die notwendigen Daten vorhanden sind.
 */
@Getter
@Setter
public class UserShowDto {

    /**
     * Die eindeutige Identifikationsnummer des Benutzers.
     * Dieses Feld ist ein Pflichtfeld, da es zur Identifikation des Benutzers benötigt wird.
     */
    @NotNull(message = "Die ID des Benutzers darf nicht null sein.")
    private Integer id;

    /**
     * Der Benutzername des Benutzers.
     * Dieses Feld ist ein Pflichtfeld, da der Benutzername zur Identifikation des Benutzers benötigt wird.
     */
    @NotNull(message = "Der Benutzername darf nicht null sein.")
    private String username;

    /**
     * Die E-Mail-Adresse des Benutzers.
     * Dieses Feld ist ein Pflichtfeld, da die E-Mail-Adresse zur Kontaktaufnahme benötigt wird.
     */
    @NotNull(message = "Die E-Mail-Adresse darf nicht null sein.")
    private String email;
}

