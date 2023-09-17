package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductMetroSpecification implements Specification<ProductEntity> {
    private final String metro;

    public ProductMetroSpecification(String metro) {
        this.metro = metro;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(metro == null){
            return null;
        }
        return criteriaBuilder.equal(root.<String>get("metro"), metro);
    }
}
