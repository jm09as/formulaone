package com.bredex.formulaone.service.validators;

import com.bredex.formulaone.model.FormulaOneTeam;
import com.bredex.formulaone.service.exceptions.IncorrectEnteredDataException;
import com.bredex.formulaone.service.Validator;

class TeamNameValidator implements Validator<FormulaOneTeam> {

    private static final String PATTERN = "([0-9]*\\s*\\p{L}+\\s*[0-9]*)+";

    @Override
    public void validate(FormulaOneTeam formulaOneTeam) throws IncorrectEnteredDataException {
        if (formulaOneTeam.getTeamName() == null) {
            throw new IncorrectEnteredDataException("nameError", "Enter a Formula 1 team name!");
        }
        if (!formulaOneTeam.getTeamName().matches(PATTERN)) {
            throw new IncorrectEnteredDataException("nameError", "Enter only letter and number!");
        }
    }
}
