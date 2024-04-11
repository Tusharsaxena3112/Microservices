package com.microservices.productservice.repository;

import org.springframework.stereotype.Repository;

import com.microservices.productservice.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> employees
            = new ArrayList<>();

    public Product add(Product employee) {
        employees.add(employee);
        return employee;
    }

    public Product findById(Long id) {
        return employees.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Product> findAll() {
        return employees;
    }

    public List<Product> findByDepartment(Long departmentId) {
        return employees.stream()
                .filter(a -> a.departmentId().equals(departmentId))
                .toList();
    }
}
