package com.geekbrains.spring.lesson6.utils;

import com.geekbrains.spring.lesson6.entities.Catalog;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.repositories.specifications.CatalogSpecification;
import com.geekbrains.spring.lesson6.repositories.specifications.ProductSpecifications;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class CatalogFilter {

    private Specification<Catalog> spec;
    private String filterDefinition;

    public CatalogFilter() {
    }

    public CatalogFilter(Map<String, String> params) {
        StringBuilder filterDefinitionBuilder = new StringBuilder();
        spec = Specification.where(null);

        if(params.containsKey("id") && !params.get("id").isBlank()){
            Long id = Long.parseLong(params.get("id"));
            spec = spec.and(CatalogSpecification.idEqual(id));
            filterDefinitionBuilder.append("&id=").append(id);
        }

        filterDefinition = filterDefinitionBuilder.toString();
    }

    public Specification<Catalog> getSpec() {
        return spec;
    }

    public void setSpec(Specification<Catalog> spec) {
        this.spec = spec;
    }

    public String getFilterDefinition() {
        return filterDefinition;
    }

    public void setFilterDefinition(String filterDefinition) {
        this.filterDefinition = filterDefinition;
    }
}
