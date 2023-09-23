package com.example.demo.ressources.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Diese Klasse ist das DTO zur Aktualisierung von Kategorien.
 * Diese Klasse wird genutzt, um Informationen einer Kategorie zu übertragen, die aktualisiert werden sollen,
 */
@Getter
@Setter
public class CategoryUpdateDto {

    /**
     * Die eindeutige Identifikationsnummer der Kategorie, die aktualisiert werden soll.
     */
    @NotNull(message = "Die ID der Kategorie darf nicht null sein.")
    private Integer id;

    /**
     * Der neue Name der Kategorie.
     */
    private String name;
}