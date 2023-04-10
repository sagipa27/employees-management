package com.example.employeesmanagement.domain.model.employee;

import com.example.employeesmanagement.infrastructure.validators.datevalidator.DateValidator;
import com.example.employeesmanagement.infrastructure.validators.datevalidator.DateValidatorUsingFormat;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.util.Assert.notNull;

public class EmployeeStartDate {

    private String value;

    public EmployeeStartDate(String value){

        String pattern = "dd-MM-yyyy";
        DateValidator validator = new DateValidatorUsingFormat("yyyy/dd/M");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");

        String uppeLimitDate =new SimpleDateFormat(pattern).format(new Date());
        notNull(value, "Date cannot be null");
        Assert.isTrue(!(validator.isValid(value)), "Date must be in the format yyyy/dd/MM");

        try{
            Date upperDate = dateFormat.parse(uppeLimitDate);
            Date hireDate = dateFormat.parse(value);
            if(hireDate.after(upperDate)){
                throw new IllegalArgumentException("Date must be before or equal to today");
            }
        }
        catch(ParseException e){
            System.out.println(e);
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
