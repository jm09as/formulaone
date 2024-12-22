package com.bredex.formulaone.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return "login";
        }
        if (error != null) {
            model.addAttribute("errorMsg", "Incorrect username or password!");
            return "login";
        }
        return "redirect:/list";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        if (!auth.getPrincipal().equals("anonymousUser")) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            model.addAttribute("msg", " You are logged out successfully!");
        }
        return "login";
    }

}
