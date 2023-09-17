package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductDistrictSpecification implements Specification<ProductEntity> {
    private final String district;

    public ProductDistrictSpecification(String district) {
        this.district = district;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if(district == null){
            return null;
        }
        return criteriaBuilder.equal(root.<String>get("district"), district);
    }
}
