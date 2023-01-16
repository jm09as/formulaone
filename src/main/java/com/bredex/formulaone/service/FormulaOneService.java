package com.bredex.formulaone.service;

import com.bredex.formulaone.model.FormulaOneTeam;
import com.bredex.formulaone.repository.FormulaRepository;
import com.bredex.formulaone.service.validators.CompositeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class FormulaOneService {

    private FormulaRepository formulaRepository;

    @Autowired
    public void setFormulaRepository(FormulaRepository formulaRepository) {
        this.formulaRepository = formulaRepository;
    }

    public void save(FormulaOneTeam formulaOneTeam) {
        formulaRepository.save(formulaOneTeam);
    }

    public void delete(FormulaOneTeam formulaOneTeam) {
        formulaRepository.deleteById(formulaOneTeam.getId());
    }

    public Map<String, String> validate(FormulaOneTeam formulaOneTeam) {
        var formulaOneValidation = CompositeValidator.getInstance();
        formulaOneValidation.validate(formulaOneTeam);
        return formulaOneValidation.getValidatorErrors();
    }

    public List<FormulaOneTeam> GetTeams() {
        return formulaRepository.findAll();
    }

    public FormulaOneTeam getTeamById(FormulaOneTeam formulaOneTeam) {
        try {
            return formulaRepository.findById(formulaOneTeam.getId()).orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("The specified value does not exist!");
        }
    }
}
