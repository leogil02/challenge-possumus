package com.leonardogil.challenge_possumus_tech.domain.validation;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.InvalidRomanNumberException;
import com.leonardogil.challenge_possumus_tech.domain.model.RomanEnum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RomanSymbolValidator {

    public static void validator(String romanNumber){
        Set<Character> romanSymbols = Arrays.stream(RomanEnum.values())
                .map(romanSymbol -> romanSymbol.name().charAt(0))
                .collect(Collectors.toSet());

        romanNumber.chars()
                .mapToObj(character -> (char) character)
                .filter(character -> !romanSymbols.contains(character))
                .findFirst()
                .ifPresent(character -> {
                    throw new InvalidRomanNumberException(String.valueOf(character));
                });
    }
}
