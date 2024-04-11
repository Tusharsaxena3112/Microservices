package com.microservices.restaurantservice.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.microservices.restaurantservice.model.Product;

import java.util.List;

@HttpExchange
public interface ProductClient {

    @GetExchange("/employee/department/{departmentId}")
    public List<Product> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
