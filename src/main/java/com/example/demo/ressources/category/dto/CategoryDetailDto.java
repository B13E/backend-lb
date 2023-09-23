package com.example.demo.ressources.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Diese Klasse ist das DTO für die Details einer Kategorie.
 * Diese Klasse wird genutzt, um Detailinformationen einer Kategorie zu übertragen, inklusive der ID,
 * des Namens und des Status der Aktivität.
 */
@Getter
@Setter
public class CategoryDetailDto {

    /**
     * Die eindeutige Identifikationsnummer der Kategorie.
     * Dieses Feld darf nicht null sein, da jede Kategorie eine eindeutige ID haben muss.
     */
    @NotNull(message = "Die ID der Kategorie darf nicht null sein.")
    private Integer id;

    /**
     * Der Name der Kategorie.
     * Dieses Feld darf nicht null sein, da eine Kategorie einen Namen haben muss.
     */
    @NotNull(message = "Der Name der Kategorie darf nicht null sein.")
    private String name;

    /**
     * Der Status der Kategorie.
     */
    @NotNull(message = "Der Aktivitätsstatus der Kategorie darf nicht null sein.")
    private Integer active;
}
