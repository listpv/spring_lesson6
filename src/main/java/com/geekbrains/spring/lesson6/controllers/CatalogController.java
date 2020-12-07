package com.geekbrains.spring.lesson6.controllers;

import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.services.CatalogService;
import com.geekbrains.spring.lesson6.services.ProductService;
import com.geekbrains.spring.lesson6.utils.CatalogFilter;
import com.geekbrains.spring.lesson6.utils.ProductFilter;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/catalogs")
public class CatalogController {

    private CatalogService catalogService;
//    private ProductService productService;
//    Sort sort;

    public CatalogController(CatalogService catalogService
//            , ProductService productService
    ) {
        this.catalogService = catalogService;
//        this.productService = productService;
    }

    @GetMapping
    public String firstRequest(Model model) {
        model.addAttribute("catalogs", catalogService.findAll());
        return "catalogs";
    }

    @GetMapping("/catalog/{id}")
    public String showCatalog(@PathVariable("id") Long id,
                              Model model
            , @RequestParam(defaultValue = "1", name = "c") Integer page
//            , @RequestParam Map<String, String> params
            )
    {
        page = (page < 1) ? 1 : page;
//        CatalogFilter catalogFilter = new CatalogFilter(params);
//        Page<Product> products = productService.findAllProductsFromCatalog(id, page - 1, 2);
        Page<Product> catalog = catalogService.findAllProductsFromCatalog(id,page - 1, 3);
        model.addAttribute("catalog", catalog);
//        model.addAttribute("filterDefinition", catalogFilter.getFilterDefinition());
        model.addAttribute("name", catalogService.findNameById(id));

        return "catalog";
    }
}
