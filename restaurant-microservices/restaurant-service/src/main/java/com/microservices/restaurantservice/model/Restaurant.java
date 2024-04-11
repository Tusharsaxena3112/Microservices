package com.microservices.restaurantservice.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Long id;
    private String name;
    private List<Product> employees = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Product> employees) {
        this.employees = employees;
    }
}
