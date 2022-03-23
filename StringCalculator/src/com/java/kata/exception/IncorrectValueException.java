package com.java.kata.exception;

import com.java.kata.log.ValueErrorType;

public class IncorrectValueException extends RuntimeException {

    private final ValueErrorType valueErrorType;
    private final int number;

    public IncorrectValueException(String description, int number, ValueErrorType valueErrorType) {
        super(description, null);
        this.valueErrorType = valueErrorType;
        this.number = number;
    }

    public ValueErrorType getValueErrorType() {
        return valueErrorType;
    }

    public int getNumber() {
        return number;
    }
}
