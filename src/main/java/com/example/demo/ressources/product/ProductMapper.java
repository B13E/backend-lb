package com.example.demo.ressources.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    // ... Weitere Mappings
    public abstract Product toEntity(ProductCreateDto productCreateDto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    public abstract ProductShowDto toShowDto(Product product);

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    // ... Weitere Mappings
    @Mapping(source = "id", target = "id")
    public abstract ProductDetailDto toDetailDto(Product product);

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    // ... Weitere Mappings
    public abstract void update(ProductUpdateDto productToUpdate, @MappingTarget Product productEntityToUpdate);
}
