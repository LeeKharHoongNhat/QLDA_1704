package com.ffse1704.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalController {
    protected static final String ERROR_404 = "404";
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle(NoHandlerFoundException ex) {
      return ERROR_404;
    }
}
