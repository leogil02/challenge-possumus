package com.leonardogil.challenge_possumus_tech.domain.model;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.InvalidRomanNumberException;

public enum RomanEnum {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private final int value;

    RomanEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static RomanEnum fromChar(char c){
        try {
            return RomanEnum.valueOf(String.valueOf(c));
        } catch (IllegalArgumentException e){
            throw new InvalidRomanNumberException(String.valueOf(c));
        }
    }

}
