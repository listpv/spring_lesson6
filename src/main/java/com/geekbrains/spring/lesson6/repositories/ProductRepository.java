package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("SELECT cp FROM Catalog c JOIN c.products cp WHERE c.id = :id ")
    Page<Product> findAllProductsFromCatalog(@Param("id") Long id, Pageable pageable);

//    @Query("SELECT c.products FROM Catalog c WHERE c.id = :id ")
//    Page<Product> findAllByCatalogId(@Param("id") Long id, Pageable pageable);

    @Query("SELECT c.products FROM Catalog c WHERE c.id = :id ")
    List<Product> findProductById(@Param("id") Long id);

    @Query("SELECT c.products FROM Catalog c WHERE c.id = :id ")
    Page<Product> findPageProductById(@Param("id") Long id, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN Catalog c WHERE c.id = :id")
    Page<Product> findProductByCatalogId(@Param("id") Long id, Pageable pageable);


    @Query("SELECT p FROM Product p WHERE p in (SELECT c.products FROM Catalog c WHERE c.id = :id)")
    Page<Product> findProductFromCatalogById(@Param("id") Long id, Pageable pageable);

}
