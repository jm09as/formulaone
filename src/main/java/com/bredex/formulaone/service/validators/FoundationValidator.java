package com.bredex.formulaone.service.validators;

import com.bredex.formulaone.model.FormulaOneTeam;
import com.bredex.formulaone.service.exceptions.IncorrectEnteredDataException;
import com.bredex.formulaone.service.Validator;

import java.time.LocalDate;

class FoundationValidator implements Validator<FormulaOneTeam> {

    @Override
    public void validate(FormulaOneTeam formulaOneTeam) throws IncorrectEnteredDataException {
        if (formulaOneTeam.getFoundingYear() == null) {
            throw new IncorrectEnteredDataException("foundationError", "Enter a date!");
        }
        if (formulaOneTeam.getFoundingYear().isAfter(LocalDate.now())) {
            throw new IncorrectEnteredDataException("foundationError", "This date is after the present!");
        }
    }
}
