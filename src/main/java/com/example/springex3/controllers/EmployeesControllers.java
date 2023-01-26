package com.example.springex3.controllers;

import com.example.springex3.Api.ApiRespone;
import com.example.springex3.models.Employees;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeesControllers {
    ArrayList<Employees> employees;
    public EmployeesControllers(){
        employees=new ArrayList<>();
    }

    @PostMapping("/addEmployee")
    public ApiRespone addEmployee(@RequestBody @Valid  Employees employee) {

        employees.add(employee);
        return  new ApiRespone("AddDone");
    }

    @GetMapping("/getAll")
    public ArrayList<Employees> getALL(){
        return employees;
    }
    @PutMapping("/updateEmployee/{id}")
    public ApiRespone updateEmployee(@PathVariable int id,@RequestBody Employees employee){
        employees.set(id,employee);
        return new ApiRespone("Update Done");
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public ApiRespone DeleteEmployee(@PathVariable int id){
        employees.remove(id);
        return new ApiRespone("Delete Done");
    }

    @PutMapping("/employeeApply/{id}")
    public ResponseEntity employeeApply(@PathVariable int id){
        Employees e=employees.get(id);
        if(e.isOnLeave()){
              return ResponseEntity.badRequest().body(String.format("The Employee is OnLeave"));
        }
        else if(e.getAnnualLeave()==0){
            return ResponseEntity.badRequest().body(String.format("The Employee is has 0 day"));

        }
        e.setOnLeave(true);
        e.setAnnualLeave(e.getAnnualLeave()-1);
        employees.set(id,e);
        return ResponseEntity.ok().body(String.format("Done"));
    }

}
