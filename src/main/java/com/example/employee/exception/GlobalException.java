package com.example.employee.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employee.dto.ApiResponse;

@ControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException exception){
        Map <String,String> map=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(f->map.put(f.getField(), f.getDefaultMessage()));
        return ResponseEntity.badRequest().body(new ApiResponse(false,"Validation Failed",map)) ;
    }
}
