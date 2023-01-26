package com.example.springex3.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeValidType implements ConstraintValidator<ValidationEmployee,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> emp= Arrays.asList("supervisor","coordinator");

        return emp.contains(s);
    }
}
