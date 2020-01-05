package vehiclesextension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    
    Vehicle(double fuelQuantity, double fuelConsumption,double tankCapacity){
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }



    String drive(double distance){
        DecimalFormat formater = new DecimalFormat("#.##");
        if(fuelQuantity>=distance*fuelConsumption){
            this.fuelQuantity-=distance*fuelConsumption;
            return String.format("%s travelled %s km",this.getClass().getSimpleName(),formater.format(distance));
        }else {
            return String.format("%s needs refueling",this.getClass().getSimpleName());
        }

    }
    void refuel(double liters){
        if(liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }else if(fuelQuantity+liters>tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity+=liters;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
