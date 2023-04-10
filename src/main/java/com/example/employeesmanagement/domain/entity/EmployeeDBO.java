package com.example.employeesmanagement.domain.entity;


import com.example.employeesmanagement.domain.model.employee.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "employee")


public class EmployeeDBO {

    @Id
    @Column(name = "employee_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "position")
    private String position;
    @Enumerated(EnumType.STRING)
    public EmployeeStatus statusEmployee = EmployeeStatus.ACTIVE;

    public static EmployeeDBO fromDomain(Employee employee){

        return new EmployeeDBO(
                employee.getId().getValue(),
                employee.getName().getValue(),
                employee.getSalary().getValue(),
                employee.getStartDate().getValue(),
                employee.getPosition().getValue(),
                EmployeeStatus.ACTIVE
        );
    }

    public static Employee toDomain(EmployeeDBO employeeDBO){

     return new Employee(
                 new EmployeeId(employeeDBO.getId()),
                 new EmployeeName(employeeDBO.getName()),
                 new EmployeeSalary(employeeDBO.getSalary()),
                 new EmployeeStartDate(employeeDBO.getStartDate()),
                 new EmployeePosition(employeeDBO.getPosition())
             );
    }

}
