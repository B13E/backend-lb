package com.example.demo.ressources.product.dto;

import com.example.demo.ressources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO-Klasse zur Repräsentation eines zu aktualisierenden Produkts.
 * Diese Klasse wird genutzt, um Produktdaten zwischen verschiedenen Schichten der Anwendung zu transportieren,
 * insbesondere beim Aktualisieren eines existierenden Produkts.
 */
@Getter  // Lombok-Annotation zum Generieren von Getter-Methoden für alle Felder
@Setter  // Lombok-Annotation zum Generieren von Setter-Methoden für alle Felder
public class ProductUpdateDto {

    /**
     * Die eindeutige Identifikationsnummer der Kategorie, die aktualisiert werden soll.
     * Dieses Feld darf nicht null sein, da jede Kategorie eine eindeutige ID haben muss.
     */
    @NotNull(message = "Die ID der Kategorie darf nicht null sein.")
    private Integer id;

    @NotNull
    private String sku;  // Stock Keeping Unit (Artikelnummer) des Produkts

    @NotNull
    private String name;

    @NotNull
    private String image;


    private String description;

    @NotNull
    private Float price;

    @NotNull
    private Integer stock;

    // Kategorie, zu der das Produkt gehört
    private Category category;
}

