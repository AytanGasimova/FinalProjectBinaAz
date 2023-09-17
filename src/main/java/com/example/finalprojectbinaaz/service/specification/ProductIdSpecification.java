package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductIdSpecification implements Specification<ProductEntity> {
    private final Long id;

    public ProductIdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(id == null){
            return null;
        }
        return criteriaBuilder.equal(root.<Long>get("id"), id);
    }
}
