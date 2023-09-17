package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.enums.TransactionType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductTransactionTypeSpecification implements Specification<ProductEntity> {
    private final TransactionType transactionType;

    public ProductTransactionTypeSpecification(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(transactionType == null){
            return null;
        }
        return criteriaBuilder.equal(root.<TransactionType>get("transactionType"), transactionType);
    }
}
