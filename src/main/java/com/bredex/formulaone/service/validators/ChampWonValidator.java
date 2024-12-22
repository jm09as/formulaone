package com.bredex.formulaone.service.validators;

import com.bredex.formulaone.model.FormulaOneTeam;
import com.bredex.formulaone.service.Validator;
import com.bredex.formulaone.service.exceptions.IncorrectEnteredDataException;

class ChampWonValidator implements Validator<FormulaOneTeam> {

    @Override
    public void validate(FormulaOneTeam formulaOneTeam) throws IncorrectEnteredDataException {
        int worldChampWon = formulaOneTeam.getWorldChampWon();
        if (worldChampWon < 0 || worldChampWon > 100) {
            throw new IncorrectEnteredDataException("worldChampWonError", "Must be a positive number and lower 100!");
        }
    }
}
