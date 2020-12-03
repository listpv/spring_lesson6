package com.geekbrains.spring.lesson6.controllers;

import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.services.CatalogService;
import com.geekbrains.spring.lesson6.services.ProductService;
import com.geekbrains.spring.lesson6.utils.ProductFilter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/catalogs")
public class CatalogController {

    private CatalogService catalogService;
    private ProductService productService;

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
                              Model model,
                              @RequestParam(defaultValue = "1", name = "p") Integer page){
        page = (page < 1) ? 1 : page;
//        model.addAttribute("catalog", catalogService.findCatalogById(id));
        List<Product> productList = catalogService.findProductsById(id);
        for(Product o : productList){
            productService.saveOrUpdate(o);
        }
        Page<Product> products = productService.findAll(page - 1, 2);
//        model.addAttribute("products", catalogService.findProductsById(id));
//        Page<Product> products = catalogService.findProductsById(id, page - 1, 2);
//        model.addAttribute("products", catalogService.findProductsById(id, page - 1, 2));
        model.addAttribute("products", products);
        model.addAttribute("name", catalogService.findNameById(id));


        return "catalog";
    }
}
