package com.example.employeesmanagement.domain.model.employee;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;

public class EmployeeId {

    private String value;

    public EmployeeId(String value) {

        notNull(value, "EmployeeId must not be null");
        Assert.isTrue(!(value.length() < 10), "EmployeeId must not be longer than 10 digits");
        Assert.isTrue(!(Pattern.matches(("[/d]+"), value)), "Employee Id must contain only numbers");
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }
}
