package com.youssef_gamal.liquibase_demo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.youssef_gamal.liquibase_demo.dtos.ProductDTO;
import com.youssef_gamal.liquibase_demo.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO productDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ProductDTO productDTO, @MappingTarget Product product);
}
