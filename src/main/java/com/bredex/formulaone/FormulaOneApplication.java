package com.bredex.formulaone;

import com.bredex.formulaone.model.Client;
import com.bredex.formulaone.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class FormulaOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormulaOneApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            var admin = new Client();
            admin.setId(1);
            admin.setRoles("ROLE_BOSS");
            admin.setRegDate(LocalDate.now());
            admin.setUsername("admin");
            admin.setPassword(new BCryptPasswordEncoder().encode("f1test2018"));
            var client = new Client();
            client.setId(2);
            client.setRoles("ROLE_CLIENT");
            client.setRegDate(LocalDate.now());
            client.setUsername("client");
            client.setPassword(new BCryptPasswordEncoder().encode("name"));
            clientRepository.saveAll(List.of(admin, client));
        };
    }

}
