package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.model.ProductFilterDto;
import org.springframework.data.jpa.domain.Specification;

public class FilterSpecification {
    public Specification<ProductEntity> filterProduct(ProductFilterDto productFilterDto) {
        Specification<ProductEntity> specification = Specification
                .where(new ProductIdSpecification(productFilterDto.getId()))
                .or(new ProductAreaSpecification(productFilterDto.getProductArea()))
                .or(new ProductFloorSpecification(productFilterDto.getOnWhatFloor()))
                .or(new ProductRoomSpecification(productFilterDto.getCountOfRoom()))
                .or(new ProductPriceSpecification(productFilterDto.getPrice()))
                .or(new ProductCitySpecification(productFilterDto.getCity()))
                .or(new ProductDistrictSpecification(productFilterDto.getDistrict()))
                .or(new ProductMetroSpecification(productFilterDto.getMetro()))
                .or(new ProductMarkSpecification(productFilterDto.getMark()))
                .or(new ProductCategoryTypeSpecification(productFilterDto.getCategoryType()))
                .or(new ProductTransactionTypeSpecification(productFilterDto.getTransactionType()));

        return specification;
    }
}
