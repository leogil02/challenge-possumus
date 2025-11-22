package com.leonardogil.challenge_possumus_tech.domain.validation;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.RomanOrderException;
import com.leonardogil.challenge_possumus_tech.domain.model.RomanEnum;

public class OrderValidator {

    public static void validator(String romanNumber){

        if (romanNumber.length() < 2) return;

        int currentMaxValueAllowed = RomanEnum.valueOf(String.valueOf(romanNumber.charAt(0))).getValue();
        int previousMaxValueAllowed = 0;

        for(int i = 1; i < romanNumber.length(); i++){

            char currentChar = romanNumber.charAt(i);
            int currentValue = RomanEnum.valueOf(String.valueOf(currentChar)).getValue();

            //Si son iguales no hace nada (XX, II, etc)
            if(currentValue == currentMaxValueAllowed) continue;

            //Si el valor actual es más grande que el máximo permitido, sí o sí es una resta (porque pasó la validación
            //de SubstractionValidator). Por ejemplo (XIX, IV, LIX)
            if(currentValue > currentMaxValueAllowed) {

                int subtraction = currentValue - currentMaxValueAllowed;
                if(previousMaxValueAllowed != 0 && subtraction > previousMaxValueAllowed){
                    throw new RomanOrderException("El orden del número entregado es incorrecto");
                }
                previousMaxValueAllowed = currentMaxValueAllowed;
                currentMaxValueAllowed = currentValue - currentMaxValueAllowed;
                continue;
            }

            //Si llega acá, el valor actual es más chico que el máximo permitido
            previousMaxValueAllowed = currentMaxValueAllowed;
            currentMaxValueAllowed = currentValue;

        }

    }

}
