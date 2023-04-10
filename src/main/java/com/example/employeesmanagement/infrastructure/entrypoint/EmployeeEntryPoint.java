package com.example.employeesmanagement.infrastructure.entrypoint;

import com.example.employeesmanagement.domain.dto.EmployeeDto;
import com.example.employeesmanagement.domain.usecase.EmployeeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeEntryPoint {

    private final EmployeeUseCase employeeUseCase;

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        List<EmployeeDto> employees = employeeUseCase.getEmployees();

        if(employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable(name = "id") String id) {
        EmployeeDto employee = employeeUseCase.getEmployee(id);

        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeUseCase.saveEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeUseCase.updateEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") String id) {
        Boolean deleted = employeeUseCase.deleteEmployee(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }


}
