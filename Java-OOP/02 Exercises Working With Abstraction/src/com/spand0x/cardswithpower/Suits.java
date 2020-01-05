package com.spand0x.cardswithpower;

public enum Suits {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
    private int valueCard;

    Suits(int value) {
        this.valueCard = value;
    }

    public int getValue() {
        return this.valueCard;
    }
}
