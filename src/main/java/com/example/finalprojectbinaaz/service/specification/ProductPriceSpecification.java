package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductPriceSpecification implements Specification<ProductEntity> {
    private final Double price;

    public ProductPriceSpecification(Double price) {
        this.price = price;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(price == null){
            return null;
        }
        return criteriaBuilder.equal(root.<Double>get("price"), price);
    }
}
