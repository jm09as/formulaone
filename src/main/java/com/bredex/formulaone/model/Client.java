package com.bredex.formulaone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "CLIENT", initialValue = 2)
    private int id;
    private String password;
    @Column(nullable = false)
    private String username;
    private String roles;

    @Column(nullable = false)
    private boolean active;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(updatable = false, name = "regDate")
    private LocalDateTime regDate = LocalDateTime.now();

    public Client() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(password, client.password) && Objects.equals(username, client.username) && Objects.equals(roles, client.roles) && Objects.equals(regDate, client.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, username, roles, regDate);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", roles='" + roles + '\'' +
                ", regDate=" + regDate +
                '}';
    }
    
}