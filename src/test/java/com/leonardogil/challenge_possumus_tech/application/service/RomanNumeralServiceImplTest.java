package com.leonardogil.challenge_possumus_tech.application.service;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.IntegerOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralServiceImplTest {

    private final RomanNumeralServiceImpl romanNumeralService = new RomanNumeralServiceImpl();

    // ** Testea to-int

    @Test
    @DisplayName("Valida correcto valor de cada símbolo romano")
    void validateSymbolValue(){
        assertEquals(1, romanNumeralService.toInteger("I"));
        assertEquals(5, romanNumeralService.toInteger("V"));
        assertEquals(10, romanNumeralService.toInteger("X"));
        assertEquals(50, romanNumeralService.toInteger("L"));
        assertEquals(100, romanNumeralService.toInteger("C"));
        assertEquals(500, romanNumeralService.toInteger("D"));
        assertEquals(1000, romanNumeralService.toInteger("M"));
    }

    @Test
    @DisplayName("Valida correcto valor total")
    void validateSummatory(){
        assertEquals(4, romanNumeralService.toInteger("IV"));
        assertEquals(14, romanNumeralService.toInteger("XIV"));
        assertEquals(19, romanNumeralService.toInteger("XIX"));
        assertEquals(40, romanNumeralService.toInteger("XL"));
        assertEquals(427, romanNumeralService.toInteger("CDXXVII"));
        assertEquals(2563, romanNumeralService.toInteger("MMDLXIII"));
        assertEquals(3999, romanNumeralService.toInteger("MMMCMXCIX"));
    }

    // ** Testea to-roman

    @Test
    @DisplayName("Valida que transforme correctamente de entero a romano")
    void validateIntegerToRoman(){
        assertEquals("I", romanNumeralService.toRoman(1));
        assertEquals("XIX", romanNumeralService.toRoman(19));
        assertEquals("CDXXVII", romanNumeralService.toRoman(427));
        assertEquals("MMMCMXCIX", romanNumeralService.toRoman(3999));
    }

    @Test
    @DisplayName("Valida que se respete el rango de números")
    void validateOutOfRange(){
        assertThrowsExactly(IntegerOutOfRangeException.class, () -> {
            romanNumeralService.toRoman(0);
        });
        assertThrowsExactly(IntegerOutOfRangeException.class, () -> {
            romanNumeralService.toRoman(-1);
        });
        assertThrowsExactly(IntegerOutOfRangeException.class, () -> {
            romanNumeralService.toRoman(4000);
        });
        assertThrowsExactly(IntegerOutOfRangeException.class, () -> {
            romanNumeralService.toRoman(null);
        });
    }

}