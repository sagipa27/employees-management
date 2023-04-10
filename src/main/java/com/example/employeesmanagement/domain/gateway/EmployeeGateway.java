package com.example.employeesmanagement.domain.gateway;

import com.example.employeesmanagement.domain.model.employee.Employee;

import java.util.List;

public interface EmployeeGateway {

    Employee save(Employee employee);

    Employee update(Employee employee);

    Boolean delete(String id);

    Employee find(String id);

    List<Employee> findAll();

    void updateSalary(String id, Integer salary);

    void updateStatusToInactive(String employeeId, String status);




}
