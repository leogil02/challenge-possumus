package com.leonardogil.challenge_possumus_tech.application.service;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.IntegerOutOfRangeException;
import com.leonardogil.challenge_possumus_tech.domain.model.RomanEnum;
import com.leonardogil.challenge_possumus_tech.domain.model.RomanGreedyValue;
import org.springframework.stereotype.Service;


@Service
public class RomanNumeralServiceImpl implements IRomanNumeralService{

    @Override
    public Integer toInteger(String romanNumber) {
        romanNumber = romanNumber.toUpperCase();
        int sum = 0;

        for(int i=0; i<romanNumber.length(); i++){
            int currentValue = RomanEnum.valueOf(String.valueOf(romanNumber.charAt(i))).getValue();
            if(romanNumber.length() > i + 1){
                int nextValue = RomanEnum.valueOf(String.valueOf(romanNumber.charAt(i + 1))).getValue();
                if (nextValue > currentValue) {
                    sum -= currentValue;
                } else {
                    sum += currentValue;
                }
            } else {
                sum += currentValue;
            }
        }
        return sum;
    }

    @Override
    public String toRoman(Integer intNumber) {

        if(intNumber == null || intNumber < 1 || intNumber > 3999)
            throw new IntegerOutOfRangeException("El número debe estar entre 1 y 3999");

        StringBuilder romanNumber = new StringBuilder();
        for(RomanGreedyValue romanGreedyValue : RomanGreedyValue.values()){
            while(intNumber >= romanGreedyValue.value){
                romanNumber.append(romanGreedyValue.symbol);
                intNumber -= romanGreedyValue.value;
            }
        }
        return romanNumber.toString();
    }



}
