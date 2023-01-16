package com.bredex.formulaone.service;

import com.bredex.formulaone.service.exceptions.IncorrectEnteredDataException;

public interface Validator<T> {

    void validate(T t) throws IncorrectEnteredDataException;
}