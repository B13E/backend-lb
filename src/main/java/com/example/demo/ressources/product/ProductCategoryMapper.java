package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import com.example.demo.ressources.product.dto.ProductDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Dieser Mapper ist für die Konvertierung von Product-Objekten in ProductDetailDto-Objekte verantwortlich.
 */
@Mapper(componentModel = "spring")
public abstract class ProductCategoryMapper {

    /**
     * Konvertiert ein Product-Objekt in ein ProductDetailDto-Objekt.
     *
     * @param product Das zu konvertierende Product-Objekt.
     * @return Ein ProductDetailDto-Objekt mit den konvertierten Daten.
     */
    @Mapping(source = "category", target = "category")
    public abstract ProductDetailDto toProductDetailDto(Product product);
}
