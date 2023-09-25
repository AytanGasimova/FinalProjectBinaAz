package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductHasDocumentSpecification implements Specification<ProductEntity> {
    private final boolean hasDocument;

    public ProductHasDocumentSpecification(boolean hasDocument) {
        this.hasDocument = hasDocument;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if(!hasDocument) {
            return null;
        }

        return criteriaBuilder.equal(root.<Double>get("hasDocument"), hasDocument);
    }
}
