package com.bredex.formulaone.service;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.service.exceptions.IncorrectEnteredDataException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

public class LoginControl {

    @Autowired
    private final ClientService clientService;

    public LoginControl(ClientService clientService) {
        this.clientService = clientService;
    }

    public Client getValidLoginClient(Client client) throws IncorrectEnteredDataException {
        try {
            return clientService.getClientByName(client);
        } catch (NoSuchElementException e) {
            throw new IncorrectEnteredDataException("nameError", "Name not found!");
        }

    }

    public void checkPassword(Client loggedInClient, Client client) throws IncorrectEnteredDataException {
        if (!loggedInClient.getPassword().equals(client.getPassword())) {
            throw new IncorrectEnteredDataException("nameError", "Incorrect password");
        }
    }
}
