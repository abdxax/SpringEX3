package com.example.springex3.models;

import com.example.springex3.Validation.ValidationAge;
import com.example.springex3.Validation.ValidationEmployee;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@AllArgsConstructor
public class Employees {
    @NotNull(message = "id Can not null")
    @Size(min  =2)
    private String id;
    @NotNull(message = "name Can not null")
    @Size(min = 4)
    private String name;
    @NotNull(message = "age Can not null")
    @ValidationAge
    private int age;
    private String role;

    private  boolean onLeave;
    @NotNull(message = "position Can not null")
    @ValidationEmployee
    private  String position;
    @NotNull(message = "employmentYear can not null")
    private int employmentYear;
    @NotNull(message = "annualLeave can not null")
    private  int annualLeave;
}
