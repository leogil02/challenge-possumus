package com.leonardogil.challenge_possumus_tech.application.validation.annotation;

import com.leonardogil.challenge_possumus_tech.application.validation.validator.ValidRomanNumeralValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidRomanNumeralValidator.class)
public @interface ValidRomanNumeral {
    String message() default "Número romano inválido";
    Class[] groups() default {};
    Class[] payload() default {};
}
