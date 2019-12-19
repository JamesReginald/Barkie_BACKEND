package com.barkie.barkie.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
