package com.example.demo.exception;

import com.example.demo.models.ErrorObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException errors,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        // catches exceptions and returns a 400 with error message
        String errorMessage = "";
        HttpStatus responseStatus = null;
        try{
            errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
            responseStatus = HttpStatus.BAD_REQUEST;
        } catch(Exception e){
            errorMessage = "Error while processing request please try again later";
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ErrorObject errorResponse = new ErrorObject(errorMessage);
        return new ResponseEntity(errorResponse, responseStatus);
    }
}