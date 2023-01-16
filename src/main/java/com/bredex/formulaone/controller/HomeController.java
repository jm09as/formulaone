package com.bredex.formulaone.controller;

import com.bredex.formulaone.model.FormulaOneTeam;
import com.bredex.formulaone.service.FormulaOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    private FormulaOneService formulaOneService;

    @Autowired
    public void setFormulaOneService(FormulaOneService formulaOneService) {
        this.formulaOneService = formulaOneService;
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @GetMapping
    public String formulaOne() {
        return "redirect:/createform";
    }

    @GetMapping("/createform")
    public String createForm(FormulaOneTeam formulaOneTeam, Model model) {
        model.addAttribute("FormulaOneTeam", formulaOneTeam);
        return "create";
    }

    @PostMapping("/create")
    public String createTeam(FormulaOneTeam formulaOneTeam, Model model) {
        Map<String, String> errorMessage = formulaOneService.validate(formulaOneTeam);
        if (errorMessage.isEmpty()) {
            formulaOneService.save(formulaOneTeam);
            return "redirect:/list";
        }
        model.addAllAttributes(errorMessage);
        model.addAttribute("FormulaOneTeam", formulaOneTeam);
        return "create";
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @GetMapping("/list")
    public String listTeam(Model model) {
        model.addAttribute("FormulaOneTeam", formulaOneService.GetTeams());
        return "list-team";
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable FormulaOneTeam id) {
        formulaOneService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{formulaOneTeam}")
    public String loadToUpdate(FormulaOneTeam formulaOneTeam, Model model) {
        model.addAttribute("FormulaOneTeam", formulaOneService.getTeamById(formulaOneTeam));
        return "create";
    }

    @PostMapping("/update/{id}")
    public String update(FormulaOneTeam formulaOneTeam) {
        formulaOneService.save(formulaOneTeam);
        return "redirect:/list";
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @ExceptionHandler(value = RuntimeException.class)
    public String error(RuntimeException e, Model model) {
        model.addAttribute("exception", e.getMessage());
        return "error";
    }
}
