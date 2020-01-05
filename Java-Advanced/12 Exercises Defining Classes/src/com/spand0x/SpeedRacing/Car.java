package com.spand0x.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPerKilo;
    private double distanceTraveled = 0;

    public Car(String model, double fuelAmount, double fuelPerKilo) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKilo = fuelPerKilo;
    }

    public void drive(double distance){
        double neededFuel = distance*this.fuelPerKilo;
        if(neededFuel>fuelAmount){
            System.out.println("Insufficient fuel for the drive");
        }else{
            fuelAmount -= neededFuel;
            distanceTraveled += distance;
        }
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void print(){
        System.out.printf("%s %.2f %.0f%n",this.model,this.fuelAmount,this.distanceTraveled);
    }
}
