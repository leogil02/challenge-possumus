package com.leonardogil.challenge_possumus_tech.domain.validation;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.RomanNumberRepetitionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepetitionValidator {

    private static final int MAX_REPETITIONS_IXCM = 3;
    private static final Set<Character> NON_REPEATABLE = Set.of('V', 'L', 'D');

    public static void validate(String romanNumber){
        int repetitions = 1;
        Map<Character, Integer> globalCount = new HashMap<>();

        for(int i = 0; i < romanNumber.length(); i++){
            char currentChar = romanNumber.charAt(i);

            if(NON_REPEATABLE.contains(currentChar)){
                int count = globalCount.getOrDefault(currentChar, 0) + 1;
                if(count > 1){
                    throw new RomanNumberRepetitionException(
                            "El símbolo '" + currentChar + "' aparece más de una vez en el número ingresado"
                    );
                }
                globalCount.put(currentChar, 1);
            }

            if(i > 0) {
                char previousChar = romanNumber.charAt(i - 1);
                if (currentChar == previousChar) {
                    repetitions++;
                    if (repetitions > MAX_REPETITIONS_IXCM) {
                        throw new RomanNumberRepetitionException(
                                "El símbolo '" + currentChar + "' se repite más de 3 veces seguidas"
                        );
                    }
                } else {
                    repetitions = 1;
                }
            }
        }
    }
}
