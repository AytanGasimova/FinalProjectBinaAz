package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.model.ProductFilterDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.Specification;
@Configuration
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
                .or(new ProductTransactionTypeSpecification(productFilterDto.getTransactionType()))
                .or(new ProductIsRenovatedSpecification(productFilterDto.isRenovated()))
                .or(new ProductHasDocumentSpecification(productFilterDto.isHasDocument()))
                .or(new ProductIsMortgageableSpecification(productFilterDto.isMortgageable()))
                ;

        return specification;
    }
}
