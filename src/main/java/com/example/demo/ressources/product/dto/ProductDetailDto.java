package com.example.demo.ressources.product.dto;

import com.example.demo.ressources.category.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

/**
 * DTO-Klasse zur Repräsentation der Details eines Produkts.
 * Diese Klasse wird genutzt, um Produktdetails zwischen verschiedenen Schichten der Anwendung zu transportieren.
 * Sie enthält Annotationen für die OpenAPI-Dokumentation und Validierung der Felder.
 */
@Getter  // Lombok-Annotation zum Generieren von Getter-Methoden für alle Felder
@Setter  // Lombok-Annotation zum Generieren von Setter-Methoden für alle Felder
@Schema(description = "DTO für die Detailansicht eines Produkts")
public class ProductDetailDto {

    @NotNull
    @Schema(description = "Einzigartige Identifikationsnummer der Produkt Liste", example = "1")
    private Integer id;  // Eindeutige Identifikationsnummer des Produkts

    @Schema(description = "SKU steht für Stock Keeping Unit (Artikelnummer)", example = "4565344561")
    private String sku;  // Stock Keeping Unit - Eindeutiger Identifikator eines Produkts

    @NotNull
    @Schema(description = "Name des Produkt", example = "AMD Ryzen 7 7800X3D")
    private String name;

    @NotNull
    @Schema(description = "Ist für ein Bild des Produkt", example = "AMD_Ryzen_7_7800X3D.jpg")
    private String image;

    @NotNull
    @Schema(description = "Eine Beschreibung des Produkts und verschiedene Informationen", example = "Produktbeschreibung, Preis, Lieferzeit, etc")
    private String description;

    @NotNull
    @Schema(description = "Preis des Produkt", example = "Preis CHF 42")
    private Float price;

    @NotNull  // Der Lagerbestand darf nicht null sein und ist somit ein Pflichtfeld
    @Schema(description = "Anzahl der Produkt im Lager", example = "3")
    private Integer stock;

    @Schema(description = "Kategorie des Produkt", example = "Technik")
    private Category category;  // Kategorie, zu der das Produkt gehört
}
