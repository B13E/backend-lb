package com.example.demo.ressources.product.dto;

import com.example.demo.ressources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO-Klasse zur Repräsentation der notwendigen Daten für die Erstellung eines Produkts.
 * Diese Klasse wird genutzt, um Produktdaten zwischen verschiedenen Schichten der Anwendung zu transportieren.
 */
@Getter  // Lombok-Annotation zum Generieren von Getter-Methoden für alle Felder
@Setter  // Lombok-Annotation zum Generieren von Setter-Methoden für alle Felder
public class ProductCreateDto {

    @NotNull
    private String sku; // Stock Keeping Unit - Eindeutiger Identifikator eines Produkts

    @NotNull
    private String name;

    @NotNull
    private String image;

    @NotNull
    private String description;

    @NotNull
    private Float price;

    @NotNull
    private Integer stock;

    // Kategorie, zu der das Produkt gehört. Kann null sein, wenn das Produkt keiner speziellen Kategorie zugeordnet ist.
    private Category category;
}
