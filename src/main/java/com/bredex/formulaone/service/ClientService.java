package com.bredex.formulaone.service;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Optional<Client> getFirstClient(int number) {
        return clientRepository.findById(number);
    }
}
