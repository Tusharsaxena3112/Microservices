package com.microservices.restaurantservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.microservices.restaurantservice.client.ProductClient;
import com.microservices.restaurantservice.model.Restaurant;
import com.microservices.restaurantservice.repository.RestaurantRepository;

import java.util.List;

@RestController
@RequestMapping("/department")
public class RestaurantController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private ProductClient employeeClient;

    @PostMapping
    public Restaurant add(@RequestBody Restaurant department) {
        LOGGER.info("Department add: {}", department);
        return repository.addDepartment(department);
    }

    @GetMapping
    public List<Restaurant> findAll() {
        LOGGER.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable Long id) {
        LOGGER.info("Department find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Restaurant> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<Restaurant> departments
                = repository.findAll();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.findByDepartment(department.getId())));
        return  departments;
    }

}
