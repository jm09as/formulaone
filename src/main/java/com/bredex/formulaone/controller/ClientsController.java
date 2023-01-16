package com.bredex.formulaone.controller;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClientsController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/home")
    public String index(Model model, Client client) {
        model.addAttribute("clients", clientService.getAllClient());
        return "index";
    }
}