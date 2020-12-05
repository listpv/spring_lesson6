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
    private ProductService productService;
    Sort sort;

    public CatalogController(CatalogService catalogService, ProductService productService) {
        this.catalogService = catalogService;
        this.productService = productService;
    }

    @GetMapping
    public String firstRequest(Model model) {
        model.addAttribute("catalogs", catalogService.findAll());
        return "catalogs";
    }

    @GetMapping("/catalog/{id}")
    public String showCatalog(@PathVariable("id") Long id,
                              Model model
//            , @RequestParam(defaultValue = "1", name = "с") Integer page,
//                              @RequestParam Map<String, String> params
            )
    {
//        page = (page < 1) ? 1 : page;
//        List<Product> productList= catalogService.findProductsById(id);
//        CatalogFilter catalogFilter = new CatalogFilter(params);
//        System.out.println(productService.findProductById(id));
//        Page<Product> products = catalogService.findProductsById(id, page - 1, 2);
//        Page<Product> products = productService.findAll(page - 1, 2);
////        Page<Product> products = productService.findAllProductsFromCatalog(id,page - 1, 2);
//        Page<Product> products = productService.findPageProductById(id, page - 1, 2);
//        model.addAttribute("products", products);
//        model.addAttribute("filterDefinition", catalogFilter.getFilterDefinition());
//        model.addAttribute("name", catalogService.findNameById(id));

        model.addAttribute("catalog", catalogService.findCatalogById(id));


        return "catalog";
    }
}
