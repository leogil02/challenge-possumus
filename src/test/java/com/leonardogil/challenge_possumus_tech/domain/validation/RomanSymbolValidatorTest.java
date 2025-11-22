package com.leonardogil.challenge_possumus_tech.domain.validation;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.InvalidRomanNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanSymbolValidatorTest {

    @Test
    @DisplayName("Valida que los símbolos válidos no arrojen error")
    void validateCorrectSymbols(){
        assertDoesNotThrow(() -> RomanSymbolValidator.validator("MDCLXVI"));
    }

    @Test
    @DisplayName("Valida que arroje error al ingresar un símbolo erroneo")
    void validateIncorrectSymbols(){
        assertThrowsExactly(InvalidRomanNumberException.class, () -> {
            RomanSymbolValidator.validator("ASDFGHJ");
        });
        assertThrowsExactly(InvalidRomanNumberException.class, () -> {
            RomanSymbolValidator.validator("XXIXP3");
        });
    }

}