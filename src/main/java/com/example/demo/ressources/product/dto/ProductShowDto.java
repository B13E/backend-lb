package com.example.demo.ressources.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO-Klasse zur Repräsentation eines Produkts für die Anzeige in der Benutzeroberfläche.
 * Diese Klasse wird genutzt, um Produktdaten zwischen verschiedenen Schichten der Anwendung zu transportieren.
 * Sie enthält nur die für die Anzeige notwendigen Felder: ID, Name und Bild.
 */
@Getter  // Lombok-Annotation zum Generieren von Getter-Methoden für alle Felder
@Setter  // Lombok-Annotation zum Generieren von Setter-Methoden für alle Felder
public class ProductShowDto {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String image;
}
