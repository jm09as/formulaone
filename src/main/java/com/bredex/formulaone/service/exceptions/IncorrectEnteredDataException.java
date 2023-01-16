package com.bredex.formulaone.service.exceptions;

public class IncorrectEnteredDataException extends Exception {

    private final String errorMessage;


    public IncorrectEnteredDataException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
