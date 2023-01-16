package com.bredex.formulaone.repository;

import com.bredex.formulaone.model.FormulaOneTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends JpaRepository<FormulaOneTeam, Integer> {
}
