package com.endava.coffeeShop;

public class EmployeeNotFoundException extends RuntimeException {

    private final Long id;

    public EmployeeNotFoundException(Long id) {
        super("Employee with id " + id + " not found.");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
