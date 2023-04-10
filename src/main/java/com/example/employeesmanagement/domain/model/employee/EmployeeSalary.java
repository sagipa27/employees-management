package com.example.employeesmanagement.domain.model.employee;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;

public class EmployeeSalary {

        private Integer value;

        public EmployeeSalary(Integer value) {

            notNull(value, "EmployeeId must not be null");
            Assert.isTrue(!(Pattern.matches(("[/d]+"), value.toString())), "Employee salary must contain only numbers");

            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
}
