package exception;

import log.ValueErrorType;

public class IncorrectValueException extends RuntimeException {

    private final ValueErrorType valueErrorType;

    public IncorrectValueException(String description, ValueErrorType valueErrorType) {
        super(description, null);
        this.valueErrorType = valueErrorType;
    }

    public ValueErrorType getValueErrorType() {
        return valueErrorType;
    }
}
