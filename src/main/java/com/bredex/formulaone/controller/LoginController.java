package com.bredex.formulaone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping
    public String formulaOne() {
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("errorMsg", "Incorrect username or password!");
        }
        if (logout != null) {
            model.addAttribute("msg", " You are logged out successfully!");
        }
        return "login";
    }

    @ExceptionHandler(value = Exception.class)
    public String error(Exception e, Model model) {
        Arrays.stream(e.getStackTrace()).forEach(System.out::println);
        model.addAttribute("exception", e.getMessage());
        model.addAttribute("exception1", e.getLocalizedMessage());
        return "error";
    }

}
