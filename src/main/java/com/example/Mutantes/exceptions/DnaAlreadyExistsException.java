package com.example.Mutantes.exceptions;

public class DnaAlreadyExistsException extends RuntimeException {
    public DnaAlreadyExistsException(String message) {
        super(message);
    }
}
