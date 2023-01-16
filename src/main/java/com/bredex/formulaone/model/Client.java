package com.bredex.formulaone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
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
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDate = LocalDate.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(password, client.password) && Objects.equals(name, client.name) && Objects.equals(regDate, client.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, name, regDate);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}