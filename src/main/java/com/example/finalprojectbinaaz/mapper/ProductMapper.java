package com.example.finalprojectbinaaz.mapper;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "sellerDto", source = "sellerEntity")
    ProductDto mapEntityToDto(ProductEntity productEntity);
    ProductEntity mapDtoToEntity(ProductDto productDto);
    ProductEntity mapDtoToEntity(ProductDto productDto, Long id);

}
