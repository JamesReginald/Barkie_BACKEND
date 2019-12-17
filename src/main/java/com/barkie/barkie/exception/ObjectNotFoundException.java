package com.barkie.barkie.exception;

/**
 * This Exception class can be thrown when there is no object found of a certain entity
 */
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException() {
        super();
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
