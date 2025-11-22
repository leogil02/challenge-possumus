package com.leonardogil.challenge_possumus_tech.domain.validation;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.RomanOrderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class OrderValidatorTest {

    @Test
    @DisplayName("Valida el orden de símbolos ingresados que no tengan substracción")
    void validateCorrectOrderWithoutSubtractions(){
        assertDoesNotThrow(() -> OrderValidator.validator("XX"));
        assertDoesNotThrow(() -> OrderValidator.validator("XXIII"));
        assertDoesNotThrow(() -> OrderValidator.validator("I"));
        assertDoesNotThrow(() -> OrderValidator.validator("VII"));
        assertDoesNotThrow(() -> OrderValidator.validator("MDCLXVI"));
        assertDoesNotThrow(() -> OrderValidator.validator("LXI"));
    }

    @Test
    @DisplayName("Valida el orden de símbolos ingresados que tengan substracción")
    void validateCorrectOrderWithSubtractions(){
        assertDoesNotThrow(() -> OrderValidator.validator("XIX"));
        assertDoesNotThrow(() -> OrderValidator.validator("IV"));
        assertDoesNotThrow(() -> OrderValidator.validator("XIV"));
        assertDoesNotThrow(() -> OrderValidator.validator("XCIV"));
        assertDoesNotThrow(() -> OrderValidator.validator("MCMXCIV"));
        assertDoesNotThrow(() -> OrderValidator.validator("MMMCM"));
    }

    @Test
    @DisplayName("Valida que arroje excepción al ingresar números en un orden erroneo")
    void validateBadOrder(){
        assertThrowsExactly(RomanOrderException.class, () -> {
            OrderValidator.validator("VIX");
        });
        assertThrowsExactly(RomanOrderException.class, () -> {
            OrderValidator.validator("XLC");
        });
    }

}