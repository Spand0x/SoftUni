package com.spand0x.cardrank;

public enum Cards {
    ACE(0), TWO(1),THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7), NINE(8), TEN(9), JACK(10), QUEEN(11), KING(12);
    private int value;
    Cards(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}