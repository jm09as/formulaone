package com.bredex.formulaone.service;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientByName(Client client) throws NoSuchElementException {
        return clientRepository.findByName(client.getName()).orElseThrow();
    }
}
