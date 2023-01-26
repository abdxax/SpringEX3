package com.example.springex3.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AgeValidation.class)
public @interface ValidationAge {
    public String message() default "Age must be more than 25 ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
