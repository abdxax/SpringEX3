package com.example.springex3.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmployeeValidType.class)
public @interface ValidationEmployee {
    public String message() default "Please insert coordinator or supervisor";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
