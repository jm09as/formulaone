package com.bredex.formulaone.controller;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.service.ClientService;
import com.bredex.formulaone.service.LoginControl;
import com.bredex.formulaone.service.exceptions.IncorrectEnteredDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/home")
    public String index(Model model, HttpSession session, Client client) {
        List<Client> clients = (List<Client>) session.getAttribute("CLIENTS");
        model.addAttribute("CLIENTS", clients != null ? clients : new ArrayList<Client>());
        return "/index";
    }

    @PostMapping("/login")
    public String login(Client client, HttpServletRequest request, Model model) {
        List<Client> clients = (List<Client>) request.getSession().getAttribute("CLIENTS");
        if (clients == null) {
            clients = new ArrayList<>();
            request.getSession().setAttribute("CLIENTS", clients);
        }
        Client loggedInClient;
        try {
            var loginControl = new LoginControl(clientService);
            loggedInClient = loginControl.getValidLoginClient(client);
            loginControl.checkPassword(loggedInClient, client);
        } catch (IncorrectEnteredDataException e) {
            model.addAttribute(e.getMessage(), e.getErrorMessage());
            return "index";
        }
        clients.add(loggedInClient);
        request.getSession().setAttribute("CLIENTS", clients);
        return "redirect:/list";
    }

    @GetMapping("/logout")
    public String logout() {
        return "/home";
    }

}
