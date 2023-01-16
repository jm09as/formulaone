package com.bredex.formulaone.service.exceptions;

public class IncorrectEnteredDataException extends Exception {


    private String errorMessage;

    public IncorrectEnteredDataException() {
    }

    public IncorrectEnteredDataException(String message) {
        super(message);
    }

    public IncorrectEnteredDataException(Throwable cause) {
        super(cause);
    }

    public IncorrectEnteredDataException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
