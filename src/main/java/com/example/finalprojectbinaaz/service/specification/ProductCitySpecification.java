package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductCitySpecification implements Specification<ProductEntity> {
    private final String city;

    public ProductCitySpecification(String city) {
        this.city = city;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if(city == null){
            return null;
        }
        return criteriaBuilder.equal(root.<String>get("city"), city);
    }
}
