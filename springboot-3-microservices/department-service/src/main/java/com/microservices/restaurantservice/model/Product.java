package com.microservices.restaurantservice.model;

public record Product(Long id, Long departmentId, String name, int age, String position) {
}
