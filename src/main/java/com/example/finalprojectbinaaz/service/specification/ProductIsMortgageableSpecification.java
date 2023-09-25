package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductIsMortgageableSpecification implements Specification<ProductEntity> {
    private final boolean isMortgageable;

    public ProductIsMortgageableSpecification(boolean isMortgageable) {
        this.isMortgageable = isMortgageable;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if(!isMortgageable) {
            return null;
        }

        return criteriaBuilder.equal(root.<Double>get("isMortgageable"), isMortgageable);
    }
}
