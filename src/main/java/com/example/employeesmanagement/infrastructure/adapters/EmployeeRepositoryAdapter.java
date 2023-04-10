package com.example.employeesmanagement.infrastructure.adapters;

import com.example.employeesmanagement.domain.entity.EmployeeDBO;
import com.example.employeesmanagement.domain.gateway.EmployeeGateway;
import com.example.employeesmanagement.domain.model.employee.Employee;
import com.example.employeesmanagement.infrastructure.adapters.jpa.IEmployeeRepositoryAdapter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryAdapter implements EmployeeGateway{

    private final IEmployeeRepositoryAdapter repositoryAdapter;


    @Override
    public Employee save(Employee employee) {

        EmployeeDBO employeeDBO = EmployeeDBO.fromDomain(employee);

        return EmployeeDBO.toDomain(repositoryAdapter.save(employeeDBO));

    }

    @Override
    public Employee update(Employee employee) {

        EmployeeDBO employeeDBO = EmployeeDBO.fromDomain(employee);

        return EmployeeDBO.toDomain(repositoryAdapter.save(employeeDBO));

    }

    @Override
    public Boolean delete(String id) {

        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<EmployeeDBO> dbo = repositoryAdapter.findById(id);
        dbo.ifPresent(value->{
            repositoryAdapter.deleteById(id);
            bool.set(true);
        });
        return bool.get();
    }

    @Override
    public Employee find(String id) {

        Optional<EmployeeDBO> dbo = repositoryAdapter.findById(id);
        if(dbo.isPresent()){
            return EmployeeDBO.toDomain(dbo.get());
        }
        else {
            throw new NullPointerException("No existe empleado con el id: " + id);
        }

    }

    @Override
    public List<Employee> findAll() {
        return repositoryAdapter.findAll().stream().map(EmployeeDBO::toDomain).toList();
    }

    @Transactional
    @Override
    public void updateSalary(String id, Integer salary) {
        repositoryAdapter.updateEmployeeSalary(id, salary);
    }

    @Transactional
    @Override
    public void updateStatusToInactive(String employeeId, String status) {
        repositoryAdapter.updateEmployeeStatusToInactive(employeeId, status);
    }
}
