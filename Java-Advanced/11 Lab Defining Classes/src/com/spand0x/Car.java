package com.spand0x;

public class Car{
    private String make;
    private String model;
    private int horsePower;

    public Car(String make) {
        this.make = make;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getInfo(){
         return "The car is: " + this.make + " " + this.model + " - " + this.horsePower + " HP.";
    }
}
