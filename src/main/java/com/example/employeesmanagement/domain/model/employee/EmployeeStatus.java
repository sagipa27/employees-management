package com.example.employeesmanagement.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class EmployeeStatus {

    private String value;

    public EmployeeStatus(String value) {

        notNull(value, "Epmployee status must not be null");
        Assert.isTrue(value.equals("Active"), "Employee's status must be Active");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
