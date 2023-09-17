package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductAreaSpecification implements Specification<ProductEntity> {
    private final Double productArea;

    public ProductAreaSpecification(Double productArea) {
        this.productArea = productArea;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if(productArea == null) {
            return null;
        }

        return criteriaBuilder.equal(root.<Double>get("productArea"), productArea);
    }
}
