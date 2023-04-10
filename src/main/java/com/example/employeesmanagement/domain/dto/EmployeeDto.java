package com.example.employeesmanagement.domain.dto;

import com.example.employeesmanagement.domain.model.employee.*;

public class EmployeeDto {

    private String id;
    private String name;
    private String position;
    private Integer salary;
    private String startDate;


    public EmployeeDto(String id, String name, String position, Integer salary, String startDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.startDate = startDate;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }



    public static Employee toDomain(EmployeeDto employeeDto) {
        return new Employee(
                new EmployeeId(employeeDto.getId()),
                new EmployeeName(employeeDto.getName()),
                new EmployeeSalary(employeeDto.getSalary()),
                new EmployeeStartDate(employeeDto.getStartDate()),
                new EmployeePosition(employeeDto.getPosition())
        );
    }

    public static EmployeeDto fromDomain(Employee employee) {
        return new EmployeeDto(
                employee.getId().getValue(),
                employee.getName().getValue(),
                employee.getPosition().getValue(),
                employee.getSalary().getValue(),
                employee.getStartDate().getValue()
        );
    }
}
