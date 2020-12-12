package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.entities.Catalog;
import com.geekbrains.spring.lesson6.entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long>
//public interface CatalogRepository extends PagingAndSortingRepository<Catalog, Long>
{

    @Query("SELECT c.products FROM Catalog c WHERE c.id = :id")
    List<Product> findProductsById(@Param("id") Long id);

//    @Query("SELECT c.products FROM Catalog c WHERE c.id = :id")
//    Page<Product> findProductsById(@Param("id") Long id, Specification<Product> spec, Pageable pageable);

    @Query("SELECT c.products FROM Catalog c WHERE c.id = :id")
    Page<Product> findProductsById(@Param("id") Long id, Pageable pageable);

    Catalog findCatalogById(Long id);

    @Query("SELECT c.name FROM Catalog c WHERE c.id = :id")
    String findNameById(@Param("id") Long id);

    @Query("SELECT cp FROM Catalog c JOIN c.products cp WHERE c.id = :id ")
    Page<Product> findAllProductsFromCatalog(@Param("id") Long id, Pageable pageable);



}
