package com.leonardogil.challenge_possumus_tech.domain.validation;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.RomanSubtractionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionValidatorTest {

    @Test
    @DisplayName("Valida correcta substracción")
    void validateCorrectSubtraction(){
        assertDoesNotThrow(() -> SubtractionValidator.validator("IV"));
        assertDoesNotThrow(() -> SubtractionValidator.validator("IX"));
        assertDoesNotThrow(() -> SubtractionValidator.validator("XL"));
        assertDoesNotThrow(() -> SubtractionValidator.validator("XC"));
        assertDoesNotThrow(() -> SubtractionValidator.validator("CD"));
        assertDoesNotThrow(() -> SubtractionValidator.validator("CM"));
        assertDoesNotThrow(() -> SubtractionValidator.validator("XIV"));
        assertDoesNotThrow(() -> SubtractionValidator.validator("DIX"));
    }

    @Test
    @DisplayName("Valida que no haya combinaciones incorrectas de substracciones")
    void validateIncorrectSubtractCombination(){
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IL");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IC");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("XD");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("VX");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("DM");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("ID");
        });
    }

    @Test
    @DisplayName("Valida que no haya una repetición de símbolos antes de una resta válida")
    void validateRepetitionBeforeSubtraction(){
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IIV");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IIX");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("XIIX");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("XXC");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("CCD");
        });
    }

    @Test
    @DisplayName("Valida que no se repita en el futuro un valor mayor o igual al símbolo pequeño de una resta")
    void validateMinorSymbolAfterSubtract(){
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IVI");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IXI");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("XXIXI");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("CDIVI");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IXV");
        });
    }

    @Test
    @DisplayName("Valida que no se repita el mismo patrón de resta más de una vez")
    void validateDoubleSubtractPattern(){
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IXIX");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("IVIV");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("XCXC");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("XXIVIV");
        });
        assertThrowsExactly(RomanSubtractionException.class, () -> {
            SubtractionValidator.validator("CMCM");
        });
    }

}