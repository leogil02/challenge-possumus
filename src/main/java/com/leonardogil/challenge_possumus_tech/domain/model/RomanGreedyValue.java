package com.leonardogil.challenge_possumus_tech.domain.model;

public enum RomanGreedyValue {
    M(1000, "M"),
    CM(900, "CM"),
    D(500, "D"),
    CD(400, "CD"),
    C(100, "C"),
    XC(90, "XC"),
    L(50, "L"),
    XL(40, "XL"),
    X(10, "X"),
    IX(9, "IX"),
    V(5, "V"),
    IV(4, "IV"),
    I(1, "I");

    public final int value;
    public final String symbol;

    RomanGreedyValue(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }
}
