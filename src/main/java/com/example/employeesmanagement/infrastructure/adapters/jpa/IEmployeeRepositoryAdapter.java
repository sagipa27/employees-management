package com.example.employeesmanagement.infrastructure.adapters.jpa;

import com.example.employeesmanagement.domain.entity.EmployeeDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepositoryAdapter extends JpaRepository<EmployeeDBO, String> {

    @Modifying
    @Query(value = "UPDATE EMPLOYEE SET SALARY=:salary WHERE employee_id=:id", nativeQuery = true)
    void updateEmployeeSalary(String id, Integer salary);


    @Modifying
    @Query(value = "UPDATE EMPLOYEE SET STATUS_EMPLOYEE=:status  WHERE employee_id=:id", nativeQuery = true)
    void updateEmployeeStatusToInactive(String id, String status);

}
