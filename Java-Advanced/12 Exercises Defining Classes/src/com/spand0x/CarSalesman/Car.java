package com.spand0x.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String weightOrColor) {
        this(model,engine);
        if(Character.isDigit(weightOrColor.charAt(0))){
            this.weight = weightOrColor;
        }else{
            this.color = weightOrColor;
        }
    }

    public Car(String model, Engine engine, String weight, String color) {
        this(model,engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.model + ":\n"+
                this.engine.getModel() + ":\n"+
                this.engine.toString() +
                "\nWeight: " + this.weight +
                "\nColor: " + this.color;
    }
}
