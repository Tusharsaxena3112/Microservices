package com.microservices.productservice.model;

public record Product(Long id, Long departmentId, String name, int age, String position) {
}
