package com.example.employeesmanagement.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class EmployeeName {

    private String value;

    public EmployeeName(String value) {

        notNull(value, "EmployeeId must not be null");
        Assert.isTrue(value.matches("[a-zA-Z]+"), "Employee name must contain only letters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
