package com.example.demo.ressources.category.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

/**
 * Diese Klasse das Data DTO für das erstellen einer Kategorie.
 * DTOs werden verwendet, um Daten zwischen Client und Server auszutauschen.
 * Diese Klasse wird verwendet, wenn eine neue Kategorie erstellt wird und enthält daher
 * Validierungsanmerkungen, um sicherzustellen, dass die notwendigen Daten vorhanden sind.
 */
@Getter
@Setter
public class CategoryCreateDto {

    /**
     * Der Name der Kategorie.
     * Dieses Feld ist ein Pflichtfeld, da eine Kategorie ohne Namen nicht sinnvoll wäre.
     */
    @NotNull(message = "Der Name der Kategorie darf nicht null sein.")
    private String name;
}