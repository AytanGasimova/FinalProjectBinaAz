package com.example.finalprojectbinaaz.mapper;

import com.example.finalprojectbinaaz.dao.entity.ImageEntity;
import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.model.ImageDto;
import com.example.finalprojectbinaaz.model.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageEntity mapDtoToEntity(ImageDto pimageDto);
}
