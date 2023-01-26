package com.example.springex3.handlingException;

import com.example.springex3.Api.ApiRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class HandlingExcep {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handling(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
                    errors.put(error.getField(),error.getDefaultMessage());
        });

        return  errors;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiRespone handlingInt(HttpMessageNotReadableException ex){
        Map<String,String> errors=new HashMap<>();


        return  new ApiRespone("Must be Integer please ");

    }
}
