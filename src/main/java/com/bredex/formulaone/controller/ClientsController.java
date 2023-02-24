package com.bredex.formulaone.controller;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class ClientsController {

    private ClientService clientService;
    private Client currentUser;


    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/home")
    public String index(Model model, Client client, Principal principal) {
        try {
            currentUser = clientService.getAllClient()
                    .stream()
                    .filter(c -> c.getUsername().equals(principal.getName()))
                    .findFirst().orElseThrow(Exception::new);
        } catch (Exception e) {
            currentUser = new Client();
            currentUser.setUsername("no name");
        }
        model.addAttribute("clients", currentUser);
        return "index";
    }
}