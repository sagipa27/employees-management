package com.example.employeesmanagement.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class EmployeePosition {

    private String value;

    public EmployeePosition(String value) {

        notNull(value, "EmployeeId must not be null");
        Assert.isTrue(value.matches("[a-zA-Z]+"), "Employee position must contain only letters");

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
