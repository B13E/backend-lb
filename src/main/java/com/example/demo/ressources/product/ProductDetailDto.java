package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;


@Getter
@Setter
@Data
@Schema(description = "DTO für die Detailansicht eines Produkts")

public class ProductDetailDto {
    @NotNull
    @Schema(description = "Einzigartige Identifikationsnummer der Produkt Liste", example = "1")
    private Integer id;

    @Schema(description = "SKU steht für Stock Keeping Unit (Artikelnummer)", example = "4565344561")
    private String sku;

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

    @NotNull
    @Schema(description = "Anzahl der Produkt im Lager", example = "3")
    private Integer stock;

    @Schema(description = "Kategori des Produkt", example = "Technik")
    private Category category;
}
