package com.cavcav.demohexagonalarchitecture.infrastructure.exceptions;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String message) {
        super(message);
    }

}

