package com.cs406.util;

/**
 * Created by ian on 15-02-06.
 */
public class EmptySetException extends RuntimeException {
    public EmptySetException() {
        super();
    }

    public EmptySetException(String message) {
        super(message);
    }
}
