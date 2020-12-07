package com.geekbrains.spring.lesson6.services;

import com.geekbrains.spring.lesson6.entities.Catalog;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.repositories.CatalogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<Catalog> findAll(){
        return (List<Catalog>) catalogRepository.findAll();
    }

    public List<Product> findProductsById(Long id){
        return catalogRepository.findProductsById(id);
    }

    public Page<Product> findProductsById(Long id, int page, int size){
        return catalogRepository.findProductsById(id, PageRequest.of(page, size));
    }

//    public Page<Product> findProductsById(Long id, Specification<Product> spec, int page, int size){
//        return catalogRepository.findProductsById(id, spec, PageRequest.of(page, size));
//    }

    public Catalog findCatalogById(Long id){
        return catalogRepository.findCatalogById(id);
    }

    public String findNameById(Long id){
        return catalogRepository.findNameById(id);
    }

    public Page<Product> findAllProductsFromCatalog(Long id, int page, int size){
        return catalogRepository.findAllProductsFromCatalog(id, PageRequest.of(page, size));
    }
}
