package com.bredex.formulaone.service.validators;

import com.bredex.formulaone.model.FormulaOneTeam;
import com.bredex.formulaone.service.exceptions.IncorrectEnteredDataException;
import com.bredex.formulaone.service.Validator;

class ChampWonValidator implements Validator<FormulaOneTeam> {

    @Override
    public void validate(FormulaOneTeam formulaOneTeam) throws IncorrectEnteredDataException {
        if (formulaOneTeam.getWorldChampWon() < 0) {
            throw new IncorrectEnteredDataException("worldChampWonError", "Must be a positive number!");
        }
    }
}
