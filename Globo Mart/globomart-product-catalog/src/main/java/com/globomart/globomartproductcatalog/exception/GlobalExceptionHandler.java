package com.globomart.globomartproductcatalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionMessage productNotFoundHandler(ProductNotFoundException ex) {
        ExceptionMessage message = new ExceptionMessage();
        message.setTimeStamp(new Date());
        message.setStatus(HttpStatus.NOT_FOUND.value());
        message.setMessage(ex.getMessage());
        return message;
    }

    @ExceptionHandler(ProductTypeNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionMessage productTypeNotFoundHandler(ProductTypeNotFoundException ex) {
        ExceptionMessage message = new ExceptionMessage();
        message.setTimeStamp(new Date());
        message.setStatus(HttpStatus.NOT_FOUND.value());
        message.setMessage(ex.getMessage());
        return message;
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ExceptionMessage handleException() {
        ExceptionMessage message = new ExceptionMessage();
        message.setTimeStamp(new Date());
        message.setStatus(HttpStatus.BAD_REQUEST.value());
        message.setMessage("Bad Request. Please contact administrator.");
        return message;
    }

}
