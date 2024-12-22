package com.bredex.formulaone.service.validators;

import com.bredex.formulaone.model.FormulaOneTeam;
import com.bredex.formulaone.service.exceptions.IncorrectEnteredDataException;
import com.bredex.formulaone.service.Validator;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class CompositeValidator implements Validator<FormulaOneTeam> {

    private static final CompositeValidator INSTANCE = new CompositeValidator();

    private Map<String, String> validatorErrors;

    private CompositeValidator() {
    }

    public static CompositeValidator getInstance() {
        return INSTANCE;
    }
    private static final List<Validator<FormulaOneTeam>> VALIDATORS = List.of( //
            new FoundationValidator(), //
            new TeamNameValidator(), //
            new ChampWonValidator()); //


    @Override
    public void validate(FormulaOneTeam formulaOneTeam) {
        validatorErrors = new HashMap<>();
        for (var v : VALIDATORS) {
            try {
                v.validate(formulaOneTeam);
            } catch (IncorrectEnteredDataException e) {
                validatorErrors.put(e.getMessage(), e.getErrorMessage());
            }
        }
    }

}
