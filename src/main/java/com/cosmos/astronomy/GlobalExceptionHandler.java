package com.cosmos.astronomy;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ClassCastException.class, NoSuchElementException.class})
    public String handleNotFound(Exception ex, Model model) {
        model.addAttribute("error", "Космический объект не найден или неверный тип");
        return "error"; // будет искать error.html в templates/
    }
}
