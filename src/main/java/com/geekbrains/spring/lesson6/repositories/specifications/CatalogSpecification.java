package com.geekbrains.spring.lesson6.repositories.specifications;

import com.geekbrains.spring.lesson6.entities.Catalog;
import com.geekbrains.spring.lesson6.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class CatalogSpecification {
    public static Specification<Catalog> idEqual(Long id) {
        return (Specification<Catalog>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);  // where p.id == id
    }
}
