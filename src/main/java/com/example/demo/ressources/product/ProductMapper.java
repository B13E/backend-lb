package com.example.demo.ressources.product;

import com.example.demo.ressources.product.dto.ProductCreateDto;
import com.example.demo.ressources.product.dto.ProductDetailDto;
import com.example.demo.ressources.product.dto.ProductShowDto;
import com.example.demo.ressources.product.dto.ProductUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Interface für den Produkt-Mapper, der verschiedene DTOs (Data Transfer Objects) in Entitätsobjekte umwandelt und umgekehrt.
 * Das Interface ist mit @Mapper annotiert, was MapStruct anweist, eine konkrete Implementierung zur Laufzeit zu generieren.
 * Das Attribut "componentModel" wird auf "spring" gesetzt, um die Integration mit dem Spring Framework zu ermöglichen.
 */
@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    /**
     * Konvertiert ein ProductCreateDto-Objekt in ein Product-Entitätsobjekt.
     * @param productCreateDto Das zu konvertierende DTO-Objekt.
     * @return Das konvertierte Entitätsobjekt.
     */
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    public abstract Product toEntity(ProductCreateDto productCreateDto);

    /**
     * Konvertiert ein Product-Entitätsobjekt in ein ProductShowDto-Objekt.
     * @param product Das zu konvertierende Entitätsobjekt.
     * @return Das konvertierte DTO-Objekt zur Anzeige von Produktinformationen.
     */
    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    public abstract ProductShowDto toShowDto(Product product);

    /**
     * Konvertiert ein Product-Entitätsobjekt in ein ProductDetailDto-Objekt.
     * @param product Das zu konvertierende Entitätsobjekt.
     * @return Das konvertierte DTO-Objekt zur Anzeige von detaillierten Produktinformationen.
     */
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    public abstract ProductDetailDto toDetailDto(Product product);

    /**
     * Aktualisiert ein vorhandenes Product-Entitätsobjekt mit Informationen aus einem ProductUpdateDto-Objekt.
     * @param productToUpdate Das DTO-Objekt mit den Aktualisierungsinformationen.
     * @param productEntityToUpdate Das zu aktualisierende Entitätsobjekt.
     */
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    public abstract void update(ProductUpdateDto productToUpdate, @MappingTarget Product productEntityToUpdate);
}
