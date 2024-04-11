package com.microservices.restaurantservice.repository;

import org.springframework.stereotype.Repository;

import com.microservices.restaurantservice.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepository {
    private List<Restaurant> departments
            = new ArrayList<>();

    public Restaurant addDepartment(Restaurant department) {
        departments.add(department);
        return department;
    }

    public Restaurant findById(Long id) {
        return departments.stream()
                .filter(department ->
                        department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Restaurant> findAll() {
        return departments;
    }

}
