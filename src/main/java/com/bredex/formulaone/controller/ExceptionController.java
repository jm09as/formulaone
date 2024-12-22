package com.bredex.formulaone.controller;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.service.exceptions.ClientNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RuntimeException.class)
    public String error(RuntimeException e, Model model) {
        Arrays.stream(e.getStackTrace()).forEach(System.out::println);
        model.addAttribute("exception", e.getMessage());
        model.addAttribute("exception1", e.getLocalizedMessage());
        return "error";
    }

    @ExceptionHandler(value = ClientNotFoundException.class)
    public String notFound(ClientNotFoundException e, Model model) {
        var client = new Client();
        client.setUsername("Error Client");
        model.addAttribute("exception", client );
        return "error";
    }
}
