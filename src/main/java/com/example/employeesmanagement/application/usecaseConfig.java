package com.example.employeesmanagement.application;


import com.example.employeesmanagement.domain.gateway.EmployeeGateway;
import com.example.employeesmanagement.domain.usecase.EmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class usecaseConfig {

    @Bean
    public EmployeeUseCase employeeUseCase(EmployeeGateway employeeGateway){
        return new EmployeeUseCase(employeeGateway);
    }
}
