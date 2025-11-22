package com.leonardogil.challenge_possumus_tech.domain.exceptions;

public class InvalidRomanNumberException extends RomanValidationException {
    public InvalidRomanNumberException(String input) {
        super("Número romano inválido: " + input);
    }
}
