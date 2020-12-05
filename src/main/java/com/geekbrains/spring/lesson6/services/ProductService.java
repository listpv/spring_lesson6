package com.geekbrains.spring.lesson6.services;

import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.repositories.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findAll(Specification<Product> spec, int page, int size) {
        return productRepository.findAll(spec, PageRequest.of(page, size));
    }

    public Page<Product> findAllProductsFromCatalog(Long id, int page, int size){
        return productRepository.findAllProductsFromCatalog(id, PageRequest.of(page, size));
    }

    public Page<Product> findAll(int page, int size){
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void saveOrUpdate(Product product) {
        productRepository.save(product);
    }

    public List<Product> findProductById(Long id){
        return productRepository.findProductById(id);
    }

    public Page<Product> findPageProductById(Long id, int page, int size){
        return productRepository.findPageProductById(id, PageRequest.of(page, size));
    }

}
