package com.bredex.formulaone.service;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.model.SecurityUser;
import com.bredex.formulaone.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("Client not found!"));
        System.out.println(client);
        return new SecurityUser(client);
    }
}
