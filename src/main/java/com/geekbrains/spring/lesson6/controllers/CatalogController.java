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

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public String firstRequest(Model model) {
        model.addAttribute("catalogs", catalogService.findAll());
        return "catalogs";
    }

    @GetMapping("/catalog/{id}")
    public String showCatalog(@PathVariable("id") Long id,
                              Model model
            , @RequestParam(defaultValue = "1", name = "c") Integer page)
    {
        page = (page < 1) ? 1 : page;
        Page<Product> catalog = catalogService.findAllProductsFromCatalog(id,page - 1, 1);
        model.addAttribute("catalog", catalog);
        model.addAttribute("name", catalogService.findNameById(id));
        model.addAttribute("catalogId", id);

        return "catalog";
    }
}
