package com.spand0x.CarSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String dispOrEffic) {
        this(model,power);
        if(Character.isDigit(dispOrEffic.charAt(0))){
            this.displacement = dispOrEffic;
        }else{
            this.efficiency = dispOrEffic;
        }
    }

    public Engine(String model, int power, String displacement, String efficiency) {
        this(model,power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Power: " + power +
                "\nDisplacement: " + displacement +
                "\nEfficiency: " + efficiency;
    }
}

