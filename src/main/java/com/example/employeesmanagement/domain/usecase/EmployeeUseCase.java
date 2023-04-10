package com.example.employeesmanagement.domain.usecase;

import com.example.employeesmanagement.domain.dto.EmployeeDto;
import com.example.employeesmanagement.domain.gateway.EmployeeGateway;
import com.example.employeesmanagement.domain.model.employee.Employee;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EmployeeUseCase {


    private final EmployeeGateway employeeGateway;


    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeDto.toDomain(employeeDto);
        return EmployeeDto.fromDomain(employeeGateway.save(employee));
    }

    public EmployeeDto getEmployee(String id) {
        Employee employee = employeeGateway.find(id);
        if (employee != null) {
            return EmployeeDto.fromDomain(employee);
        }
        else {
            throw new NullPointerException("No existe empleado con el id: " + id);
        }

    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeDto.toDomain(employeeDto);
        return EmployeeDto.fromDomain(employeeGateway.update(employee));
    }

    public Boolean deleteEmployee(String id){
        return employeeGateway.delete(id);
    }

    public List<EmployeeDto> getEmployees() {
        List<Employee> employee = employeeGateway.findAll();
        return employee.stream().map(EmployeeDto::fromDomain).toList();
    }
}
