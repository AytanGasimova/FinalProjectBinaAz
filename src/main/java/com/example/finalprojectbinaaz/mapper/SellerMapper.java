package com.example.finalprojectbinaaz.mapper;

import com.example.finalprojectbinaaz.dao.entity.SellerEntity;
import com.example.finalprojectbinaaz.model.SellerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {
    SellerDto mapEntityToDto(SellerEntity sellerEntity);
    SellerEntity mapDtoToEntity(SellerDto sellerDto);
    SellerEntity mapDtoToEntity(SellerDto sellerDto, Long id);
    List<SellerDto> mapListEntityToListDto(List<SellerEntity> sellerEntityList);
}
