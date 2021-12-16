package com.task.customlogging.exception;

public class UserDefinedException extends RuntimeException {

    private final String message;

    public UserDefinedException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
