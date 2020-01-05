package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    
    protected Vehicle(double fuelQuantity, double fuelConsumption){
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }
    
    public String drive(double distance){
        DecimalFormat formater = new DecimalFormat("#.##");
        if(fuelQuantity>=distance*fuelConsumption){
            this.fuelQuantity-=distance*fuelConsumption;
            return String.format("%s travelled %s km",this.getClass().getSimpleName(),formater.format(distance));
        }else {
            return String.format("%s needs refueling",this.getClass().getSimpleName());
        }

    }
    protected void refuel(double liters){
        this.fuelQuantity+=liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
