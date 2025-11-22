package com.leonardogil.challenge_possumus_tech.domain.validation;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.RomanNumberRepetitionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepetitionValidatorTest {

    @Test
    @DisplayName("Valida correcta repecición")
    void validateCorrectRepetition(){
        assertDoesNotThrow(() -> RepetitionValidator.validate("III"));
        assertDoesNotThrow(() -> RepetitionValidator.validate("V"));
        assertDoesNotThrow(() -> RepetitionValidator.validate("XXX"));
        assertDoesNotThrow(() -> RepetitionValidator.validate("L"));
        assertDoesNotThrow(() -> RepetitionValidator.validate("CCC"));
        assertDoesNotThrow(() -> RepetitionValidator.validate("D"));
        assertDoesNotThrow(() -> RepetitionValidator.validate("MMM"));
        assertDoesNotThrow(() -> RepetitionValidator.validate("XXXIX"));
    }

    @Test
    @DisplayName("Valida que los símbolos repetibles no se repitan más de 3 veces seguidas")
    void validateIncorrectRepetition(){
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("IIII");
        });
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("XXXX");
        });
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("CCCC");
        });
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("MMMM");
        });
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("XXXXIX");
        });
    }

    @Test
    @DisplayName("Valida que los símbolos no repetibles no aparezcan más de una vez")
    void validateIncorrectNonRepeatable(){
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("VV");
        });
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("LL");
        });
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("DD");
        });
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("VIV");
        });
        assertThrowsExactly(RomanNumberRepetitionException.class, () -> {
            RepetitionValidator.validate("LXL");
        });
    }

}