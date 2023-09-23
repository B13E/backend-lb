package com.example.demo.ressources.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Diese Klasse ist das DTO für die Anzeige von Kategorieinformationen.
 * Diese Klasse wird genutzt, um Informationen einer Kategorie zur Anzeige zu übertragen,
 * inklusive der ID, des Namens und des Status.
 */
@Getter
@Setter
public class CategoryShowDto {

    /**
     * Die eindeutige Identifikationsnummer der Kategorie.
     */
    @NotNull(message = "Die ID der Kategorie darf nicht null sein.")
    private Integer id;

    /**
     * Der Name der Kategorie.
     */
    @NotNull(message = "Der Name der Kategorie darf nicht null sein.")
    private String name;

    /**
     * Der Aktivitätsstatus der Kategorie.
     */
    @NotNull(message = "Der Aktivitätsstatus der Kategorie darf nicht null sein.")
    private Integer active;
}