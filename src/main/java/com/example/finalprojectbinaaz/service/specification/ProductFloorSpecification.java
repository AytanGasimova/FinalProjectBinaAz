package com.example.finalprojectbinaaz.service.specification;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductFloorSpecification implements Specification<ProductEntity> {
    private final Integer onWhatFloor;

    public ProductFloorSpecification(Integer onWhatFloor) {
        this.onWhatFloor = onWhatFloor;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root,
                                 CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(onWhatFloor == null){
            return null;
        }
        return criteriaBuilder.equal(root.<Integer>get("onWhatFloor"), onWhatFloor);
    }
}
