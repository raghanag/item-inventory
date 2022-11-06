package com.example.demo.exception;

import com.example.demo.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorResponse> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            // Todo: Map unique error id for each message
            ErrorResponse errorResponse = new ErrorResponse("1", error.getDefaultMessage());
            details.add(errorResponse);
        }
        return new ResponseEntity(details, HttpStatus.BAD_REQUEST);
    }
}
