package com.geekbrains.spring.lesson6.utils;

import com.geekbrains.spring.lesson6.entities.Catalog;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.Order;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.repositories.CatalogRepository;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import com.geekbrains.spring.lesson6.repositories.OrderRepository;
import com.geekbrains.spring.lesson6.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleData {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private CatalogRepository catalogRepository;

    public SampleData(CustomerRepository customerRepository, ProductRepository productRepository,
                      OrderRepository orderRepository, CatalogRepository catalogRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.catalogRepository = catalogRepository;
    }

    @PostConstruct
    public void init() {

//        Product product1 = new Product("Orange", 50.);
//        Product product2 = new Product("Lemon", 70.);
//        Product product3 = new Product("Lime", 20.);
//        Product product4 = new Product("Mango", 110.);
//        Product product5 = new Product("Apple", 95.);
//        Product product6 = new Product("Pineapple", 76.);
//        Product product7 = new Product("Avocado", 123.);
//        Product product8 = new Product("Chicken", 125.);
//
//        Customer customer1 = new Customer("Alex");
//        Customer customer2 = new Customer("Alena");
//
//        Catalog catalog1 = new Catalog("Food");
//        Catalog catalog2 = new Catalog("Phone");
//
//        catalog1.add(product1);
//        catalog1.add(product2);
//        catalog1.add(product3);
//        catalog1.add(product4);
//        catalog2.add(product5);
//        catalog2.add(product6);
//        catalog2.add(product7);
//        catalog2.add(product8);
//
//
//        Order order1 = new Order();
//        order1.setTotalPrice(product1.getPrice());
//        order1.setCustomer(customer1);
//
//        order1.setCode("0001");
//
//        Order order2 = new Order();
//        order2.setTotalPrice(product2.getPrice());
//        order2.setCustomer(customer2);
//
//        order2.setCode("0002");
//
//        productRepository.save(product1);
//        productRepository.save(product2);
//        productRepository.save(product3);
//        productRepository.save(product4);
//        productRepository.save(product5);
//        productRepository.save(product6);
//        productRepository.save(product7);
//        productRepository.save(product8);
//
//        customerRepository.save(customer1);
//        customerRepository.save(customer2);
//
//        catalogRepository.save(catalog1);
//        catalogRepository.save(catalog2);
//
//        orderRepository.save(order1);
//        orderRepository.save(order2);

    }
}
