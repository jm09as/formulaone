package com.bredex.formulaone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Formulateam")
public class FormulaOneTeam {

    @Id
    @SequenceGenerator(name = "FORMULA", initialValue = 5)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "FORMULA")
    private int id;
    private String teamName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate foundingYear;
    private int worldChampWon;
    private boolean registrationFee;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormulaOneTeam that = (FormulaOneTeam) o;
        return id == that.id && worldChampWon == that.worldChampWon && registrationFee == that.registrationFee && Objects.equals(teamName, that.teamName) && Objects.equals(foundingYear, that.foundingYear);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "FormulaOneTeam{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", foundingYear=" + foundingYear +
                ", worldChampWon=" + worldChampWon +
                ", registrationFee=" + registrationFee +
                '}';
    }
}


