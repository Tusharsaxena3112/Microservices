package com.microservices.productservice.controller;

import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class ProductController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository repository;

    @PostMapping
    public Product add(@RequestBody Product employee) {
        LOGGER.info("Employee add: {}", employee);
        return repository.add(employee);
    }

    @GetMapping
    public List<Product> findAll() {
        LOGGER.info("Employee find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Product> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }

}
