package com.bredex.formulaone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "FORMULATEAM")
public class FormulaOneTeam {

    @Id
    @SequenceGenerator(name = "FORMULA", initialValue = 5)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "FORMULA")
    private int id;

    @Column(nullable = false, length = 40)
    private String teamName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, updatable = false)
    private LocalDate foundingYear;

    private int worldChampWon;

    private boolean registrationFee;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false, name = "regDate")
    private LocalDate registrationDate = LocalDate.now();

    @Override
    public String toString() {
        return "FormulaOneTeam{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", foundingYear=" + foundingYear +
                ", worldChampWon=" + worldChampWon +
                ", registrationFee=" + registrationFee +
                ", registrationDate=" + registrationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormulaOneTeam that = (FormulaOneTeam) o;
        return id == that.id && worldChampWon == that.worldChampWon && registrationFee == that.registrationFee && Objects.equals(teamName, that.teamName) && Objects.equals(foundingYear, that.foundingYear) && Objects.equals(registrationDate, that.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, foundingYear, worldChampWon, registrationFee, registrationDate);
    }
}


