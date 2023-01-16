package com.bredex.formulaone.repository;

import com.bredex.formulaone.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM client where name = ?1")
    Optional<Client> findByName(String name);
}
