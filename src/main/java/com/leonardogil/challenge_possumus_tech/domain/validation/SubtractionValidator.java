package com.leonardogil.challenge_possumus_tech.domain.validation;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.RomanSubtractionException;
import com.leonardogil.challenge_possumus_tech.domain.model.RomanEnum;

import java.util.Set;

public class SubtractionValidator {

    private static final Set<String> VALID_SUBTRACTIONS = Set.of(
            "IV", "IX", "XL", "XC", "CD", "CM"
    );

    public static void validator(String romanNumber) {

        for (int i = 0; i < romanNumber.length() - 1; i++) {

            char currentChar = romanNumber.charAt(i);
            char nextChar = romanNumber.charAt(i + 1);

            int currentValue = RomanEnum.valueOf(String.valueOf(currentChar)).getValue();
            int nextValue = RomanEnum.valueOf(String.valueOf(nextChar)).getValue();

            if (nextValue > currentValue) {
                String subtraction = "" + currentChar + nextChar;

                //Directamente es una substracción invalida (por ejemplo IM)
                if (!VALID_SUBTRACTIONS.contains(subtraction)) throw new RomanSubtractionException(
                        "La substracción '" + subtraction + "' no es válida"
                );

                //Valida que en un futuro no aparezca nada con un valor mayor o igual al símbolo pequeño de la resta.
                //Ignora el valor futuro se encuentra en una resta
                //Por ejemplo IVI
                for(int j = i + 2; j < romanNumber.length(); j++){

                    if(romanNumber.length() > j + 1){
                        String futureValueSubtraction = "" + romanNumber.charAt(j) + romanNumber.charAt(j + 1);
                        if(VALID_SUBTRACTIONS.contains(futureValueSubtraction)){
                            //Para ignorar el próximo valor también
                            j++;
                            continue;
                        }
                    }

                    int futureValue = RomanEnum.valueOf(String.valueOf(romanNumber.charAt(j))).getValue();
                    if(futureValue >= currentValue ){
                        throw new RomanSubtractionException("Teniendo la substracción '" + subtraction +
                                "', se añadió un símbolo de valor igual o menor al " +
                                "valor más pequeño de la sustracción (" + currentChar + ") luego de esta");
                    }
                }



            }

            //Doble símbolo antes de una resta
            //Por ejemplo IIV
            if (i - 1 >= 0) {
                char previousChar = romanNumber.charAt(i - 1);
                int previousValue = RomanEnum.valueOf(String.valueOf(previousChar)).getValue();

                if (previousValue == currentValue && nextValue > currentValue) {
                    String substraction = "" + previousChar + currentChar + nextChar;
                    throw new RomanSubtractionException("La substracción '" + substraction + "' no es válida");
                }
            }

        }

        //Valida que no se repita 2 veces el mismo patrón de resta
        VALID_SUBTRACTIONS.forEach(subtraction -> {
            if(romanNumber.split(subtraction, -1).length > 2) {
                throw new RomanSubtractionException("La resta '" + subtraction + "' se repitió más de una vez");
            }
        });



    }
}
