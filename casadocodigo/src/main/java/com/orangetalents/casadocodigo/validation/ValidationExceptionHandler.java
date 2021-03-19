package com.orangetalents.casadocodigo.validation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ValidationExceptionDto> errors = new ArrayList<>();

        fieldErrors.forEach(e -> {
            ValidationExceptionDto erro = new ValidationExceptionDto(e.getField(), e.getDefaultMessage());
            errors.add(erro);
        });

        globalErrors.forEach(e -> {
            ValidationExceptionDto erro = new ValidationExceptionDto(e.getObjectName(), e.getDefaultMessage());
            errors.add(erro);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    /*
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handlerRuntimeException(RuntimeException exception){
        Map<String, String> error = new HashMap<>();
        error.put("message",exception.getMessage());
        error.put("status",HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
     */
}
