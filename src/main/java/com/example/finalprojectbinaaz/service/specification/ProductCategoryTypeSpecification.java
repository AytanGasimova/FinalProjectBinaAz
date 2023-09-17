package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.enums.CategoryType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductCategoryTypeSpecification implements Specification<ProductEntity> {
    private final CategoryType categoryType;

    public ProductCategoryTypeSpecification(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if(categoryType == null){
            return null;
        }
        return criteriaBuilder.equal(root.<CategoryType>get("categoryType"), categoryType);
    }
}
