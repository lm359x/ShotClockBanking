package ru.lm359.shotclockbanking.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegistrationError extends RuntimeException{
    public RegistrationError(String message) {
        super(message);
    }
}
