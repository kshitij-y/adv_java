package com.example.ProductApp.Exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings("unused")
    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Exception ex, Model model){
        model.addAttribute("errorMessage", "Something went Wrong");
        return "error-page";
    }
}
