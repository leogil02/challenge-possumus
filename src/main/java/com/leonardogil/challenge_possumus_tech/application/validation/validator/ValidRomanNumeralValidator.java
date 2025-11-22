package com.leonardogil.challenge_possumus_tech.application.validation.validator;


import com.leonardogil.challenge_possumus_tech.application.validation.annotation.ValidRomanNumeral;
import com.leonardogil.challenge_possumus_tech.domain.validation.OrderValidator;
import com.leonardogil.challenge_possumus_tech.domain.validation.RepetitionValidator;
import com.leonardogil.challenge_possumus_tech.domain.validation.RomanSymbolValidator;
import com.leonardogil.challenge_possumus_tech.domain.validation.SubtractionValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidRomanNumeralValidator implements ConstraintValidator<ValidRomanNumeral, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isBlank()) return false;

        String romanNumber = value.toUpperCase();

        RomanSymbolValidator.validator(romanNumber);
        RepetitionValidator.validate(romanNumber);
        OrderValidator.validator(romanNumber);
        SubtractionValidator.validator(romanNumber);

        return true;

    }
}
